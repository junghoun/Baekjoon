import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1956 {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		map = new int[V+1][V+1];
		
		for(int i =0; i <= V; i++) {
			Arrays.fill(map[i], 20000);
			map[i][i] = 0;
		}
		
		int v1, v2, val;
		for(int i =0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			map[v1][v2] = val;
		}
		
		for(int k =1; k<= V; k++) {
			for(int i = 1; i<= V; i++) {
				for(int j =1; j<= V; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = 20000;
		for(int i =1 ; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(i==j) continue;
				if(map[i][j] != 20000 && map[j][i] != 20000) {
					min = Math.min(min, map[i][j] + map[j][i]);					
					
				}
			}
		}
		
		System.out.println(min);
		System.out.println(min == 20000 ? -1 : min);
		
	}
}
