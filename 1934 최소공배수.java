import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(lcm(A, B));
		}

	}

	private static int gcd(int x, int y) {

		while (y > 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}

		return x;
	}

	private static int lcm(int x, int y) {

		return (x * y) / gcd(x, y);
	}
}