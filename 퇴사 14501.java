import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+2][2];
		int[] dp = new int[N+2];
		
		
		for(int i =1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N; i > 0; i--) {
			int day = i+ map[i][0];
			if(day <= N+1)
				dp[i] = Math.max(map[i][1] + dp[day], dp[i+1]);
			else
				dp[i] = dp[i+1];
			
		}
		
		System.out.println(dp[1]);
		
	}

	
}
