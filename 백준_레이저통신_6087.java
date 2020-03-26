import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_레이저통신_6087 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		int[][] temp = new int[N][M];
		int start = 0;
		int rx = 0, ry = 0;
		Queue<Laser> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					if (start == 0) {
						q.add(new Laser(i, j, -1, 0));
						temp[i][j] = 0;
						start = 1;
					} else {
						rx = i;
						ry = j;
					}

				}
					temp[i][j] = Integer.MAX_VALUE;
			}
		}
		temp[q.peek().x][q.peek().y] = 0;
		start = Integer.MAX_VALUE;
		
	
		
		while (!q.isEmpty()) {

			Laser l = q.poll();

			if (l.x == rx && l.y == ry) {
				start = Math.min(l.cnt, start);
			}

			for (int i = 0; i < 4; i++) {
				int nx = l.x + dx[i];
				int ny = l.y + dy[i];
				int nc = l.cnt;
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || map[nx][ny] == '*')
					continue;

				
				if (l.d != i && l.d != -1) {
					nc++;
				}
				
				if(temp[nx][ny] < nc) continue;
				temp[nx][ny] = nc;
				
				q.add(new Laser(nx, ny, i, nc));

			}

		}


		System.out.println(start);
	}

	static class Laser {
		int x;
		int y;
		int d;
		int cnt;

		Laser(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

}
