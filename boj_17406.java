import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17406 {
	static int[][] map,temp, calc;
	static int N, M, K, min = Integer.MAX_VALUE;
	static boolean[] v;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[K];
		arr = new int[K];
		
		map = new int[N][M];
		temp = new int[N][M];
		calc = new int[K][3];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			calc[i][0] = Integer.parseInt(st.nextToken());
			calc[i][1] = Integer.parseInt(st.nextToken());
			calc[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(min);
	}
	
	static void dfs(int cnt) {
		if(cnt == K) {
			
			for(int i =0; i < N; i++) {
				for(int j =0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			for(int i =0; i < K; i++) {
				int rr = calc[arr[i]][0];
				int cc = calc[arr[i]][1];
				int ss = calc[arr[i]][2];
				turn(rr, cc, ss);
				
				
			}
			
			for(int i =0; i < N; i++) {
				int sum = 0;
				for(int j =0; j < M; j++) {
					sum+= temp[i][j];
				}
				if(min > sum)
					min = sum;
			}
			
			return;
		}
		
		
		for(int i = 0; i < K; i++) {
			if(v[i])
				continue;
			v[i] = true;
			arr[cnt] = i;
			dfs(cnt+1);
			v[i] = false;
		}
		
	}
	
	// r-s, c-s , r+s, c+s
	static void turn(int r, int c, int s) {
        int sy, sx, ey, ex, start ;
        for(int ss = s ; ss >= 1; ss-- ) {
           sx = r-ss-1;
           sy = c-ss-1;
           ex = r+ss-1;
           ey = c+ss-1;
           
           start = temp[sx][sy];
           
           for(int i = sx; i < ex; i++) {
        	   temp[i][sy] = temp[i+1][sy];
           }
           
           for(int j = sy; j < ey; j++) {
        	   temp[ex][j] = temp[ex][j+1];
           }
           
           for(int i = ex; i > sx; i--) {
        	   temp[i][ey] = temp[i-1][ey];
           }
           
           for(int j = ey; j > sy; j--) {
        	   temp[sx][j] = temp[sx][j-1];
           }
           temp[sx][sy+1] = start;
        }
    }
	
	
}
