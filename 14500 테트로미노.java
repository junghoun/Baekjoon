import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i =0; i < N; i++) { 
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i =0; i < N; i++) { 
			for(int j =0; j < M; j++) {
				dfs(i, j, 0, 0);
				find(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int cnt, int sum) {
		 
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || v[nx][ny]) {
                continue;
            }
            
            v[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
            v[nx][ny] = false;
 
        }
	}
	
	
	static void find(int x, int y) {
		int cnt = 4;
		int sum = map[x][y];
		int min = Integer.MAX_VALUE;
		for(int i =0; i < 4; i++) { 
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			
			if(cnt < 3)
				return;
			
			if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1) {
				cnt--;
				continue;
			}
			min = Math.min(min, map[nx][ny]);
			sum += map[nx][ny];
		}
		
		if(cnt == 4) {
			sum -= min;
		}
		max = Math.max(max, sum);
	}
	
}
