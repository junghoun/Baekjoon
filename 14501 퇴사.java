import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[] v, temp;
	static int count;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		map = new int[N][2];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		System.out.println(max);
	}

	private static void solve(int cnt) {
		if (cnt == map.length) {
			if (check(v)) {
				int sum = 0;
				for (int i = 0; i < cnt; i++) {
					if (v[i]) {
						sum += map[i][1];
					}
				}
				max = Math.max(sum, max);
			}
			return;
		}

		v[cnt] = true;
		solve(cnt + 1);

		v[cnt] = false;
		solve(cnt + 1);
	}

	private static boolean check(boolean[] v) {
		temp = new boolean[v.length];
		for (int i = 0; i < v.length; i++) {
			if (v[i] && temp[i])
				return false;
			if (v[i]) {
				for (int j = 0; j < map[i][0] ; j++) {
					if(i + j > map.length-1)
						return false;
					temp[i + j] = true;
				}
			}
		}

		return true;
	}
}