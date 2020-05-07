import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6987 {
	static int map[][], temp[][];
	static int[] t1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] t2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[6][3];
		temp = new int[6][3];
		for (int c = 0; c < 4; c++) {
			int sum  = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					sum += map[i][j];
				}
			}
			
			flag = false;
			if(sum ==30)
				dfs(0);
			System.out.print(flag == true ? 1 + " "  : 0 + " ");
			
		}

		System.out.println();

	}

	static void dfs(int cnt) {
		if (cnt == 15) {
			if (!flag) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if (temp[i][j] != map[i][j])
							return;
					}
				}
				flag = true;
				return;
			} else
				return;

		}

		int c1 = t1[cnt];
		int c2 = t2[cnt];

		temp[c1][0]++;
		temp[c2][2]++;
		dfs(cnt + 1);
		temp[c1][0]--;
		temp[c2][2]--;

		temp[c1][1]++;
		temp[c2][1]++;
		dfs(cnt + 1);
		temp[c1][1]--;
		temp[c2][1]--;

		temp[c1][2]++;
		temp[c2][0]++;
		dfs(cnt + 1);
		temp[c1][2]--;
		temp[c2][0]--;
	}
}
