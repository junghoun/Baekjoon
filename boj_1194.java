import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1194 {
	static int N, M;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M][1 << 6];

		String s = "";
		Data start = null;
		for (int i = 0; i < N; i++) {
			s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0')
					start = new Data(i, j, 0, 0);
			}
		}

		int result = bfs(start);
		System.out.println(result);
	}

	static int bfs(Data start) {
		Queue<Data> q = new LinkedList<>();
		;

		q.offer(start);
		v[start.x][start.y][0] = true;
		Data d;

		while (!q.isEmpty()) {

			d = q.poll();
			if (map[d.x][d.y] == '1') {
				return d.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				int key = d.key;
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || map[nx][ny] == '#' || v[nx][ny][key])
					continue;
				
				if('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					key |= (1 << (map[nx][ny]-'a'));
				}
				
				if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if((key & (1 << (map[nx][ny]-'a'))) == 0) {
						continue;
					}
				}
				
				v[nx][ny][key] = true;
				q.offer(new Data(nx, ny, key, d.cnt+1));
				
			}

		}

		return -1;
	}

	static class Data {
		int x;
		int y;
		int key;
		int cnt;

		Data(int x, int y, int key, int cnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}

	}
}
