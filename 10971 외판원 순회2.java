import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] v;
	static int result = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		v = new boolean[N];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0);
		System.out.println(result);
	}

	private static void solve(int cnt) {
		if (cnt == map.length) {

			if (!check(arr)) {
				return;
			}
			else {
				result = Math.min(result, sum(arr));
				return;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (v[i])
				continue;
			arr[cnt] = i + 1;
			v[i] = true;
			solve(cnt + 1);
			v[i] = false;

		}

	}

	static boolean check(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (map[arr[i] - 1][arr[i + 1] - 1] == 0)
				return false;
		}
		if (map[arr[arr.length - 1]-1][arr[0]-1] == 0)
			return false;
		return true;
	}

	static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			sum += map[arr[i] - 1][arr[i + 1] - 1];
		}
		sum += map[arr[arr.length - 1]-1][arr[0]-1];
		return sum;
	}

}