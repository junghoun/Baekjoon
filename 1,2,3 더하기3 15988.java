import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 1) {
				System.out.println(1);
				continue;
			}

			if (N == 2) {
				System.out.println(2);
				continue;
			}
			
			if (N ==3) {
				System.out.println(4);
				continue;
			}
			long[] dp = new long[1000001];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			dp[4] = 7;

			for (int i = 4; i <= N; i++) {
				dp[i] = (dp[i - 1]%1000000009 + dp[i - 2]%1000000009 + dp[i-3]%1000000009) % 1000000009;
			}

			System.out.println(dp[N]);

		}
	}

}
