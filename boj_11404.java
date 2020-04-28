import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
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
			if(map[start][end] > val)
				map[start][end] = val;
		}
		
		
		for(int k =0; k < N; k++) {
			for(int i =0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE && map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] != Integer.MAX_VALUE)
					sb.append(map[i][j] + " ");
				else
					sb.append(0 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}