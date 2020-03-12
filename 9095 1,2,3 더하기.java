import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int t= 1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i =4; i <=N; i++) { 
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			System.out.println(dp[N]);
		}
	}
	
	

}