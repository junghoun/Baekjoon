import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2458 {
	static int[][] s;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		boolean flag;
		
		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			s = new int[N+1][N+1];
			for(int i =1; i <= N; i++) {
				for(int j =1; j<= N; j++) {
					if(i==j) continue;
					s[i][j] =2001;
					
				}
			}
			int v1, v2;
			for(int i =0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				v1 = Integer.parseInt(st.nextToken());
				v2 = Integer.parseInt(st.nextToken());
				s[v1][v2] = 1;
			}
			
			for(int k =1; k<= N; k++) {
				for(int i =1; i<= N; i++) {
					for(int j =1; j <= N; j++) {
						if(s[i][j] > s[i][k] + s[k][j])
							s[i][j] = s[i][k] + s[k][j];
					}
				}
			}
			int result = 0;
			for(int i =1; i <=N; i++) {
				flag = true;
				for(int j =1; j<= N; j++) {
					if(s[i][j] >=2001 && s[j][i] >= 2001) {
						flag = false;
						break;
					}
				}
				result += flag ? 1 : 0;
			}
			
			
			System.out.println(result);
			
		
		
	}
}
