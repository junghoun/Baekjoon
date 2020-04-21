import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] map = new char[12][6];
	static boolean[][] v = new boolean[12][6];
	static int cnt;
	static ArrayList<Data> list = new ArrayList<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve();
		
		System.out.println(cnt);
	}

	static void solve() {
		while (true) {

			boolean flag = false;

			for (int i = 0; i < 12; i++) {
				Arrays.fill(v[i], false);
			}

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!v[i][j] && map[i][j] != '.') {
						bfs(i, j);

						if (list.size() >= 4) {
							for (Data d : list) {
								map[d.x][d.y] = '.';
							}
							flag = true;
						}
					}
					list.clear();
				}
			}
			if(!flag) break;
			cnt++;
			drop();
			
		}
	}

	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();

		v[x][y] = true;
		q.add(new Data(x, y));

		char c = map[x][y];

		list.add(new Data(x, y));

		while (!q.isEmpty()) {
			Data d = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx < 0 || ny < 0 || nx > 11 || ny > 5 || v[nx][ny] || map[nx][ny] != c)
					continue;
				list.add(new Data(nx, ny));
				q.add(new Data(nx, ny));
				v[nx][ny] = true;
			}
		}
	}
	
	static void drop() {
		for(int i =0; i < 6; i++) {
			for(int j = 11; j >0; j--) {
				
				if(map[j][i] == '.') {
					for(int k = j-1; k >=0; k--) {
						if(map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
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
