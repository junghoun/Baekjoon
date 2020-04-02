import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_현주가좋아하는제곱근놀이_6782 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			long N = Long.parseLong(br.readLine());
			int cnt = 0;
			if (N == 1) {
				cnt = 1;
				N = 2;
			}
			for (; N != 2;) {
				long temp = (long) Math.sqrt(N);

				if (temp * temp == N) {
					N = (long) temp;
					cnt++;
				} else {
					long val = (temp + 1) * (temp + 1);
					cnt += val - N;
					N = val;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

}
