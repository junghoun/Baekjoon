import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7206 {
	static int[] dp = new int[100000];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());

			sb.append("#" + t + " " + solve(N) + "\n");
		}

		System.out.println(sb);
	}

	static int solve(int n) {

		if (dp[n] != 0) {
			return dp[n];
		}

		if (n < 10) {
			dp[n] = 0;
			return 0;
		}
		int sample = 0;
		int one = 0, two = 0, three = 0;
		String temp = String.valueOf(n);

		for (int i = 1; i < temp.length(); i++) {
			one = Integer.parseInt(temp.substring(0, i));
			two = Integer.parseInt(temp.substring(i, temp.length()));
			sample = Math.max(sample, solve(one * two));

		}
		if (temp.length() > 2) {
			for (int i = 1; i < temp.length(); i++) {
				for (int j = i + 1; j < temp.length(); j++) {
					one = Integer.parseInt(temp.substring(0, i));
					two = Integer.parseInt(temp.substring(i, j));
					three = Integer.parseInt(temp.substring(j, temp.length()));
					sample = Math.max(sample, solve(one * two * three));
				}
			}
		}
		return dp[n] = sample + 1;
	}

}
