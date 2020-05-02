import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472 {
	static int[][] map;
	static int N, M, cnt = 2, result = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean flag;
	static Queue<Data> border;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		int t = cnt - 3;
loop:	for (int k = 0; k < t; k++) {
			border = new LinkedList<>();
			cnt = 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == cnt) {
						border(i, j);
					}
				}
			}
			find();
			if(flag)
				break loop;
		}
		
		System.out.println(result);

	}

	static void find() {

		int x = 0, y = 0, dir = -1, line = Integer.MAX_VALUE, dx, dy, dc;
		while (!border.isEmpty()) {
			
			Data d = border.poll();
			dx = d.x;
			dy = d.y;
			dc = 0;
			// 위
			while (true) {
				dx--;
				dc++;
				if (dx < 0 || map[dx][dy] == cnt || map[dx][dy] != 0 && ((map[dx][dy] != cnt && dc <= 2)))
					break;
				if (map[dx][dy] != cnt && map[dx][dy] != 0) {
					if (line > dc) {
						x = dx;
						y = dy;
						dir = 0;
						line = dc;
					}
					break;
				}
			}
			dx = d.x;
			dy = d.y;
			dc = 0;
			// 오
			while (true) {
				dy++;
				dc++;
				if (dy > M-1 || map[dx][dy] == cnt || map[dx][dy] != 0 && ((map[dx][dy] != cnt && dc <= 2)))
					break;
				if (map[dx][dy] != cnt && map[dx][dy] != 0) {
					if (line > dc) {
						x = dx;
						y = dy;
						dir = 1;
						line = dc;
					}
					break;
				}
			}
			dx = d.x;
			dy = d.y;
			dc = 0;
			// 왼
			while (true) {
				dy--;
				dc++;
				if (dy < 0 || map[dx][dy] == cnt || (map[dx][dy] != 0 && (map[dx][dy] != cnt && dc <= 2)))
					break;
				if (map[dx][dy] != cnt && map[dx][dy] != 0) {
					if (line > dc) {
						x = dx;
						y = dy;
						dir = 2;
						line = dc;
					}
					break;
				}
			}
			dx = d.x;
			dy = d.y;
			dc = 0;
			// 아
			while (true) {
				dx++;
				dc++;
				if (dx > N-1 || map[dx][dy] == cnt || map[dx][dy] != 0 && ((map[dx][dy] != cnt && dc <= 2)))
					break;
				if (map[dx][dy] != cnt && map[dx][dy] != 0) {
					if (line > dc) {
						x = dx;
						y = dy;
						dir = 3;
						line = dc;
					}
					break;
				}
			}

		}
		cnt = 2;
		if(line == Integer.MAX_VALUE) {
			result = -1;
			flag = true;
			return;
		}
		result += line-1;
		bfs(x, y);
	}

	static void border(int x, int y) {
		int count = 0;

		if (x == 0 || map[x - 1][y] == map[x][y])
			count++;
		if (x == N - 1 || map[x + 1][y] == map[x][y])
			count++;
		if (y == 0 || map[x][y - 1] == map[x][y])
			count++;
		if (y == M - 1 || map[x][y + 1] == map[x][y])
			count++;

		if (count != 4)
			border.add(new Data(x, y));

	}
	

	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		map[x][y] = cnt;
		q.add(new Data(x, y));

		while (!q.isEmpty()) {
			Data d = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || map[nx][ny] == 0 || v[nx][ny])
					continue;
				map[nx][ny] = cnt;
				v[nx][ny] = true;
				q.add(new Data(nx, ny));
			}

		}
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
