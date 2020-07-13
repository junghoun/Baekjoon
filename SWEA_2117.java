import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117 {
	static int N,M, ans;
	static int[][] map;
	static int[] count = new int[22];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		count[1] = 1;
		for(int i =2; i< 22; i++) {
			count[i] = i*i + (i-1)*(i-1);
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[3*N][3*N];
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N; j++) {
					map[i+N][j+N] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0; i < N; i++) {
				for(int j =0; j < N; j++) {
					for(int k = 1; k<= N+1; k++) {
						ans = Math.max(ans, dfs(i+N,j+N,k));
					}
				}
			}
			
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	static int dfs(int x, int y, int k) {
		int cnt = 0;
		
		int house = find(x, y, k);
		
		int benefit = M * house - count[k];
		
		if(benefit >= 0) cnt = house;
		
		return cnt;
	}
	
	static int find(int x, int y, int k) {
		int cnt = 0;
		
		if(k == 1) {
			if(map[x][y] == 1)
				cnt = 1;
		}else {
			
			for(int i = 0; i < 2*k-1; i++) {
				if(map[x-(k-1) + i][y] == 1) cnt++;
			}
			
			for(int i = 1; i< k; i++) {
				for(int j = 0; j < 2*k-1-(2*i); j++) {
					if(map[x-(k-1)+i+j][y-i]== 1) cnt++;
					if(map[x-(k-1)+i+j][y+i]== 1) cnt++;
				}
			}
			
		}
		
		return cnt;
	}
}
