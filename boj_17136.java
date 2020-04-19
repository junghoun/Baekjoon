import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136 {
	static int[][] map = new int[10][10];
	static int[] confetti = { 0, 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}

	static void dfs(int idx, int cnt) {
		if(idx == 100) {
			min = Math.min(min, cnt);
			return;
		}
		
		int x = idx / 10;
		int y = idx % 10;
		
		if(min <= cnt) return;
		
		if (map[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
				if (confetti[i] > 0) {
					if (check(x, y, i)) {
						full(x, y, i, 0);
						confetti[i]--;
						dfs(idx + 1, cnt + 1);
						full(x, y, i, 1);
						confetti[i]++;
					}
				}
			}
		}else {
			dfs(idx+1, cnt);
		}
	}

	static boolean check(int x, int y, int idx) {
		if (x + idx > 10 || y + idx > 10)
			return false;

		for (int i = x; i < x + idx; i++) {
			for (int j = y; j < y + idx; j++) {
				if (map[i][j] != 1)
					return false;
			}
		}

		return true;
	}

	static void full(int x, int y, int idx, int val) {
		for (int i = x; i < x + idx; i++) {
			for (int j = y; j < y + idx; j++) {
				map[i][j] = val;
			}
		}
	}
}
