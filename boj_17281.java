import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17281 {
	static int N, max = Integer.MIN_VALUE;
	static int[][] arr;
	static int[] field, order, temp, true_order;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][9];
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		temp = new int[9];
		true_order = new int[9];
		v = new boolean[9];
		
		dfs(1);
		
		System.out.println(max);
		
	}
	
	static void dfs(int cnt) {
		if(cnt == 9) {
			true_order = temp.clone();
			int t = true_order[0];
			true_order[0] = true_order[1];
			true_order[1] = true_order[2];
			true_order[2] = true_order[3];
			true_order[3] = t;
			max = Math.max(max, calc(true_order));
			return;
		}
		
		
		for(int i=1; i < 9; i++) {
			if(v[i])
				continue;
			v[i] = true;
			temp[cnt] = order[i];
			dfs(cnt+1);
			v[i] = false;
		}
	}
	
	static int calc(int[] good) {
		
		int play = 0;
		int result = 0;
		for(int g = 0; g < N; g++) {
			int out = 0;
	
			field = new int[4];
			while(out < 3) {
				
				int val = good[play++];
				if(play == 9) play = 0;
				
				int score = arr[g][val];
				
				if(score == 0) {
					out++;
				}
				else {
					field[0]++;
					int sum = 0;
					if(score ==1) {
						sum += field[3];
						for(int i =2; i >=0; i--)
							field[i+1] = field[i];
						field[0] = 0;
					}
					else if(score == 2) {
						sum += field[3] + field[2];
						for(int i =1; i >= 0; i--)
							field[i+2] = field[i];
						field[1] = field[0] = 0;
					}
					else if(score == 3) {
						sum += field[3] + field[2] + field[1];
						field[3] = field[0];
						field[2] = field[1] = field[0] = 0;
					}
					else {
						sum += field[0] + field[1] + field[2] + field[3];
						field[3] = field[2] = field[1] = field[0] = 0;
					}
					
					result += sum;
				}	
			}
		}
		return result;
	}
}
