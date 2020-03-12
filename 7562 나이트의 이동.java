import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] map;
	static boolean[][] v;
	static int cnt, fx, fy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int N, x, y;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[N][N];
			cnt = 0;
			bfs(x, y);
			System.out.println(cnt);
		}
	}

	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));

		Data d;
		v[x][y] = true;
		int nx, ny;
bye:	while (!q.isEmpty()) {
			int T = q.size();

			for (int t = 0; t < T; t++) {
				d = q.poll();

				if (d.x == fx && d.y == fy)
					break bye;

				for (int i = 0; i < 8; i++) {
					nx = d.x + dx[i];
					ny = d.y + dy[i];
					if (nx < 0 || ny < 0 || nx > map.length - 1 || ny > map[0].length - 1 || v[nx][ny])
						continue;
					v[nx][ny] = true;
					q.add(new Data(nx, ny));
				}
			}
			cnt++;
		}
	}

	static class Data {
		int x, y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}