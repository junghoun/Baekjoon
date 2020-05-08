import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5427 {
	static int w, h, cnt;
	static char[][] map;
	static boolean flag;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static Queue<Data> sg, fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[w][h];
			sg = new LinkedList<>();
			fire = new LinkedList<>();
			
			for (int i = 0; i < w; i++) {
				String s = br.readLine();
				for (int j = 0; j < h; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = s.charAt(j);
					if (map[i][j] == '@')
						sg.offer(new Data(i, j));
					if (map[i][j] == '*')
						fire.offer(new Data(i, j));
				}
			}
			flag = false;
			bfs();
			
			System.out.println(flag == true ? cnt : "IMPOSSIBLE");
		}
	}
	
	static void bfs() {
		cnt = 1;
loop:	while (!sg.isEmpty() || !fire.isEmpty()) {
			int fsize = fire.size();
			Data d;
			for (int k = 0; k < fsize; k++) {
				d = fire.poll();

				for (int i = 0; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];

					if (nx < 0 || ny < 0 || nx > w - 1 || ny > h - 1 || map[nx][ny] == '#'
							|| map[nx][ny] == '*')
						continue;
					map[nx][ny] = '*';
					fire.offer(new Data(nx, ny));
				}
			}

			int ssize = sg.size();
			
			for (int k = 0; k < ssize; k++) {
				d = sg.poll();

				for (int i = 0; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];

					if (nx < 0 || ny < 0 || nx > w - 1 || ny > h - 1) {
						flag = true;
						break loop;
					}

					if(map[nx][ny] =='.') {
						sg.offer(new Data(nx, ny));
						map[nx][ny] ='@';
					}
				}
			}
			cnt++;
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
