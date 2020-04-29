import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6109 {
	static int[][] map;
	static int N;
	static String input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			input = st.nextToken();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int j =0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	static void solve() {
		int pre = -1;
		int temp = 0;
		if(input.equals("up")) {
			pre = -1;
			temp = 0;
			for(int i =0; i < N; i++) {
				pre = -1;
				for(int j =0; j < N; j++) {
					if(map[j][i]!= 0) {
						if(pre==-1) {
							pre=j;
							continue;
						}
						if(map[j][i] == map[pre][i]) {
							map[j][i] =0;
							map[pre][i] *=2;
							pre=-1;
						}else {
							pre=j;
						}
					}
				}
			}
			for(int i =0; i < N; i++) {
				pre = 0;
				for(int j =0; j < N; j++) {
					if(map[j][i]!= 0) {
						temp=map[j][i];
						map[j][i] = 0;
						map[pre++][i] = temp;
						
					}
				}
			}
		}
		else if(input.equals("down")) {
			for(int i =0; i < N; i++) {
				pre = -1;
				for(int j =N-1; j >= 0; j--) {
					if(map[j][i]!= 0) {
						if(pre==-1) {
							pre=j;
							continue;
						}
						if(map[j][i] == map[pre][i]) {
							map[j][i] =0;
							map[pre][i] *=2;
							pre=-1;
						}else {
							pre=j;
						}
					}
				}
			}
			for(int i =0; i < N; i++) {
				pre = N-1;
				for(int j =N-1; j >= 0; j--) {
					if(map[j][i]!= 0) {
						temp=map[j][i];
						map[j][i] = 0;
						map[pre--][i] = temp;
						
					}
				}
			}
		}else if(input.equals("left")) {
			for(int i =0; i < N; i++) {
				pre = -1;
				for(int j =0; j < N; j++) {
					if(map[i][j]!= 0) {
						if(pre==-1) {
							pre=j;
							continue;
						}
						if(map[i][j] == map[i][pre]) {
							map[i][j] =0;
							map[i][pre] *=2;
							pre=-1;
						}else {
							pre=j;
						}
					}
				}
			}
			for(int i =0; i < N; i++) {
				pre = 0;
				for(int j =0; j < N; j++) {
					if(map[i][j]!= 0) {
						temp=map[i][j];
						map[i][j] = 0;
						map[i][pre++] = temp;
						
					}
				}
			}
		}else{
			for(int i =0; i < N; i++) {
				pre = -1;
				for(int j =N-1; j >= 0; j--) {
					if(map[i][j]!= 0) {
						if(pre==-1) {
							pre=j;
							continue;
						}
						if(map[i][j] == map[i][pre]) {
							map[i][j] =0;
							map[i][pre] *=2;
							pre=-1;
						}else {
							pre=j;
						}
					}
				}
			}
			for(int i =0; i < N; i++) {
				pre = N-1;
				for(int j =N-1; j >= 0; j--) {
					if(map[i][j]!= 0) {
						temp=map[i][j];
						map[i][j] = 0;
						map[i][pre--] = temp;
						
					}
				}
			}
		}
		
		
	}
}
