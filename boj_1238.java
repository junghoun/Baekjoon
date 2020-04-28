import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int i =0; i < N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			map[start][end] = val;
		}
		
		
		for(int k=0; k < N; k++) {
			for(int i =0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE && map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int result[] = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i =0; i < N; i++) {
			result[i] = map[i][X-1] + map[X-1][i];
			max = Math.max(max,  result[i]);
		}
		
		System.out.println(max);
	}
}
