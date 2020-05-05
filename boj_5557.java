import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5557 {
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[N+1][21];
		int[] map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][map[0]] = 1;
		
		
		for(int i = 2; i < N+1;i++) {
			for(int j = 0; j < 21; j++) {
				if(dp[i-1][j] != 0) {
					if(j + map[i-1] <=20)
						dp[i][j+map[i-1]] += dp[i-1][j];
					if(j - map[i-1] >=0)
						dp[i][j-map[i-1]] += dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N-1][map[N-1]]);
	}
	
	
}
