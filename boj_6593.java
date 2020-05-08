import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6593 {
	static char[][][] map;
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int L, R, C, cnt;
	static Queue<Data> q;
	static Data result;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			map = new char[L][R][C];

			q = new LinkedList<>();
			String s = "";
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					s = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = s.charAt(k);
						if (map[i][j][k] == 'S') {
							q.add(new Data(i, j, k));
						}

					}
				}
				br.readLine();
			}
			cnt = 0;
			flag = false;
			bfs();
			System.out.println(flag == true ? ("Escaped in " + cnt + " minute(s).") : "Trapped!");
		}
		
	}

	static void bfs() {
		
loop:	while (!q.isEmpty()) {
			
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data d = q.poll();
				

				for (int i = 0; i < 6; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];
					int nz = d.z + dz[i];

					if (nx < 0 || ny < 0 || nz < 0 || nx > L - 1 || ny > R - 1 || nz > C - 1 || map[nx][ny][nz] == '#' || map[nx][ny][nz] == 'S')
						continue;
					
					if(map[nx][ny][nz] == 'E') {
						cnt = cnt+1;
						flag = true;
						break loop;
					}
					
					if(map[nx][ny][nz] == '.') {
						q.add(new Data(nx, ny, nz));
						map[nx][ny][nz] = 'S';
					}
				}

			}
			cnt++;
		}
	}

	static class Data {
		int x;
		int y;
		int z;

		Data(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;

		}
	}
}
