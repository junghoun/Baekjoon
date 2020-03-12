import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[1001][3];
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		for(int i =1; i <=N; i++) {
			s = br.readLine().split(" ");
			dp[i][0] = Integer.parseInt(s[0]);
			dp[i][1] = Integer.parseInt(s[1]);
			dp[i][2] = Integer.parseInt(s[2]);
		}
		
		for(int i = 2; i <=N; i++) { 
			dp[i][0] = Math.min(dp[i][0] + dp[i-1][1], dp[i][0] + dp[i-1][2]);
			dp[i][1] = Math.min(dp[i][1] + dp[i-1][0], dp[i][1] + dp[i-1][2]);
			dp[i][2] = Math.min(dp[i][2] + dp[i-1][0], dp[i][2] + dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		
	}

}