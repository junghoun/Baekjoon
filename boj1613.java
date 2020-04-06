import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1613 {
	static int[][] map;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		
		
		for(int i =0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1][num2] = -1;
			map[num2][num1] = 1;
		}
		
		for(int x = 1; x <= n; x++) {
			for(int i = 1; i <=n; i++) {
				for(int j =1; j<=n; j++) {
					if(map[i][j] != 0 || map[i][x] != map[x][j] )
						continue;
					map[i][j] = map[i][x];
				}
			}
		}
		
		
		int s = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(map[start][end] + "\n");
		}
		
		System.out.println(sb);
	}
	
	
}