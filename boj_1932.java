import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932 {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		dp[0][0] = 0;
		dp[1][1] = Integer.parseInt(br.readLine());
		
		int val;
		for(int i = 2; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				val = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.max(val+ dp[i-1][j-1], val + dp[i-1][j]);
			}
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		int max = 0;
		for(int j = 1; j < N+1; j++) {
			max = Math.max(max, dp[N][j]);
		}
		
		System.out.println(max);
	}
}
