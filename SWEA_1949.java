import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1949 {
	static int N, K, result;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			int max = 0;
			result = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j])
						max = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						v = new boolean[N][N];
						dfs(i, j, 1, true);
					}
				}
			}
			sb.append("#" + t + " " + result + "\n");

		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int cnt, boolean flag) {
		result = Math.max(result, cnt);
		v[x][y] = true;
		
		for(int i =0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || v[nx][ny])
				continue;
//			if(nx >= 0 && ny>=0 && nx <N && ny <N && !v[nx][ny]) { 
			
			if(map[nx][ny] < map[x][y]) {
				dfs(nx, ny, cnt+1, flag);
			}else {
				if(flag) {
					for(int k = 1; k<=K; k++) {
						if(map[nx][ny]-k < map[x][y]) {
							map[nx][ny]-=k;
							dfs(nx, ny, cnt+1, false);
							map[nx][ny]+=k;
						}
					}
				}
			}
		}
//	}
		v[x][y] = false;
		
	}

	static class Data {
		int x;
		int y;
		int val;
		int cnt;
		boolean flag;

		Data(int x, int y, int val, int cnt, boolean flag) {
			this.x = x;
			this.y = y;
			this.val = val;
			this.cnt = cnt;
			this.flag = flag;
		}

	}
}
