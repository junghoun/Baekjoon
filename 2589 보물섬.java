import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M;
	static boolean[][] v;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new String[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j].equals("L")) {
					bfs(i, j);
				}
			}
		}

		System.out.println(max);
	}

	

	static void bfs(int x, int y) {
		v = new boolean[N][M];
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));
		int cnt = -1;
		v[x][y] = true;
		Data d;
		int nx, ny;
		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			
			for (int t = 0; t < size; t++) {
				d = q.poll();
				for (int i = 0; i < 4; i++) {
					nx = d.x + dx[i];
					ny = d.y + dy[i];
					if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || v[nx][ny] || map[nx][ny].equals(("W")))
						continue;
					v[nx][ny] = true;
					q.add(new Data(nx, ny));
				}	
			}
			
		}
		if(cnt > max)
			max = cnt;
	}

	static class Data {
		int x;
		int y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}