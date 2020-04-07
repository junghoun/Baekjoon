import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class boj_17144 {
	static int[] dx = {-1, 0, 1 , 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map, temp;
	static Queue<Data> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		temp = new int[R][C];
		
		int top = 0, bot=0;
		q = new LinkedList<>();
		for(int i =0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					temp[i][j] = -1;
					top = i-1;
					bot = i;
				}
				if(map[i][j] != -1 && map[i][j] != 0) {
					q.add(new Data(i, j));
				}
			}
		}
		
		for(int t =0; t< T; t++) {
			temp = new int[R][C];
			
			
			for(int i =0; i < R; i++) {
				for(int j =0; j < C; j++) {
					if(map[i][j] >0)
						diffusion(i, j);
				}
			}
			
			for(int i =0; i< R; i++) {
				for(int j =0; j <C; j++) {
					map[i][j] += temp[i][j];
				}
			}
			
			airCleaner(top, bot);
			

		}
		
		
		int cnt = 0;
		
		for(int i =0; i < R; i++) {
			for(int j =0; j < C; j++) {
				if(map[i][j] >0)
					cnt+= map[i][j];
			}
		}
		
		
		
		System.out.println(cnt);
		
	}
	
	static void diffusion(int x, int y) {
		
			int cnt = 0, val = 0;
			for(int i =0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || map[nx][ny] == -1)
					continue;
				
				temp[nx][ny] += map[x][y]/5;
				cnt++;
			}
			
			map[x][y] -= (map[x][y]/5) *cnt;
		
	
	}
	static void airCleaner(int top, int bot) {
		
		for(int i = top-1; i >0; i--) {
			map[i][0] = map[i-1][0];
			
		}
		for(int j = 0; j < map[0].length-1; j++) {
			map[0][j] = map[0][j+1];
			
		}
		for(int i =0; i < top; i++) {
			map[i][map[0].length-1] = map[i+1][map[0].length-1];
			
		}
		
		for(int j = map[0].length-1; j >1; j--) {
			map[top][j] = map[top][j-1];
			
		}
		map[top][1] = 0;
		
		
		
		for(int i = bot+1; i < map.length-1; i++) {
			map[i][0] = map[i+1][0];
			
		}
		
		for(int j = 0; j < map[0].length-1; j++) {
			map[map.length-1][j] = map[map.length-1][j+1];
			
		}
		
		for(int i = map.length-1; i > bot; i--) {
			map[i][map[0].length-1] = map[i-1][map[0].length-1];
			
		}
		
		for(int j = map[0].length-1; j >1; j--) {
			map[bot][j] = map[bot][j-1];
			
		}
		map[bot][1] = 0;
		
	}
	
	public static class Data{
		int x;
		int y;
		
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
