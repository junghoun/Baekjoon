import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_욕심쟁이판다_1937 {
	static int[][] map, dp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max, N;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
	

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i =0; i< N; i++) {
			for(int j =0; j < N; j++) {
				if(dp[i][j] == 0)
					max = Math.max(max, find(i,j));
			}
		}
		
		
		
		System.out.println(max);
	}

	static int find(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		int val = 1;
		
		for(int i =0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || map[x][y] >= map[nx][ny])
				continue;
			
			val = Math.max(val, find(nx, ny) +1);
		}
		
		return dp[x][y] = val;
		
	}
	
	
}
