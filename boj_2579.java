import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] val = new int[N+1];
		
		
		for(int i =1; i <= N; i++) { 
			val[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = val[1];
		if(N >1)
			dp[2] = val[1] + val[2];
		
		
		for(int i = 3; i <= N; i++) { 
			dp[i] = Math.max(val[i] + val[i-1] + dp[i-3], val[i] + dp[i-2]);
		}
		System.out.println(dp[N]);
	}

}
