import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17471 {
	static int N, min = Integer.MAX_VALUE;
	static int[] people, temp;
	static int[][] arr;
	static boolean[] v, v2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		temp = new int[N + 1];
		arr = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		int size = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				arr[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}

		dfs(1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void dfs(int cnt) {
		if (cnt == N+1) {
			int one = 0, two = 0;
			for (int i = 1; i <= N; i++) {
				if (v[i]) {
					temp[i] = 7;
					one = 1;
				} else {
					two = 1;
					temp[i] = -7;
				}
			}
			
			if(one+two == 2) {
				v2 = new boolean[N+1];
				
				sum = 0;
				g1 = 0; g2 = 0;
				for(int i =1; i <= N; i++) {
					if(temp[i] == 7 && !v2[i]) {
						check(i);
						g1 = sum;
						break;
					}
				}
				sum =0;
				for(int i = 1; i <= N; i++) {
					if(temp[i] == -7 && !v2[i]) {
						check(i);
						g2 = sum;
						break;
					}
				}
				for(int i =1; i <= N; i++) {
					if(!v2[i])
						return;
				}

				min = Math.min(min, Math.abs(g1-g2));
			}

			return;
		}

		v[cnt] = true;
		dfs(cnt + 1);
		v[cnt] = false;
		dfs(cnt + 1);
	}
	
	static int sum, g1, g2;
	static void check(int idx) {
		v2[idx] = true;
		sum += people[idx];
		for(int i =1; i <= N; i++) {
			if(!v2[i] && temp[i] == temp[idx] && arr[idx][i] ==1) {
				check(i);
			}
		}
		
		
	}
	
	
}
