import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573 {
	static int[][] map, temp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M, count;
	static boolean[][] v;
	static Queue<Data> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		temp = new int[N][M];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					q.add(new Data(i, j));
				}
			}
		}

		int result = 0;
	
			while (!q.isEmpty()) {
				result++;
				int size = q.size();
				
				
				for(int i =0; i < N; i++) {
					Arrays.fill(temp[i], 0);
				}
				
				for (int t = 0; t < size; t++) {
					Data d = q.poll();
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int nx = d.x + dx[i];
						int ny = d.y + dy[i];

						if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
							continue;
						if (map[nx][ny] == 0) {
							cnt++;
						}
					}

					if (cnt <= map[d.x][d.y]) {
						temp[d.x][d.y] = map[d.x][d.y] - cnt;
						q.add(new Data(d.x, d.y));
					} else
						temp[d.x][d.y] = 0;
				}
				
				for(int i =0; i < N; i++) {
					for(int j =0; j < M; j++) {
						map[i][j] = temp[i][j];
					}
				}
				
				
				
				if (q.size() == 0) {
					result = 0;
					break;
				}
				v = new boolean[N][M];
				count = 1;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (!v[i][j] && temp[i][j] != 0)
							bfs(i, j);
					}
				}
				
				
								
				if (count >= 3)
					break;
			}
			
		System.out.println(result);
	}

	static void bfs(int x, int y) {
		temp[x][y] = count;
		v[x][y] = true;

		Queue<Data> qq = new LinkedList<>();
		qq.add(new Data(x, y));

		while (!qq.isEmpty()) {
			Data d = qq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || v[nx][ny] || temp[nx][ny] == 0)
					continue;
	
				temp[nx][ny] = count;
				v[nx][ny] = true;
				qq.add(new Data(nx, ny));
			}
		}
		count++;
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
