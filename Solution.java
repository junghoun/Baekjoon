import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static int[][] map;
	static int N;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[N];
			for(int i =0; i < N; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			
			half(0, 0);
			sb.append("#").append(t).append(" ");
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void half(int start, int cnt) {
		if(cnt == N/2) {
			result = Math.min(result, calc());
			return;
		}
		
		for(int i = start; i< N; i++) {
			if(v[i]) continue;
			v[i] = true;
			half(i+1, cnt+1);
			v[i] = false;
		}
	}
	
	static int calc() {
		int A =0, B =0;
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(v[i] && v[j])
					A+= map[i][j];
				if(!v[i] && !v[j])
					B+= map[i][j];
			}
		}
		
		
		return Math.abs(A-B);
	}
	
	
}