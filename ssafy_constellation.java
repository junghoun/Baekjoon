import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ssafy_constellation{
	static int[][] map;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int cnt;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int t = 1; t<= T; t++) {
			
			map = new int[10][10];
			v = new boolean[10][10];
			cnt = 2;
			for(int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < 10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0; i < 10; i++) {
				for(int j =0; j < 10; j++) {
					if(map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			sb.append("#" + t + " ").append(cnt-2 + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));
			
		int nx, ny;
		while(!q.isEmpty()) {
			Data d = q.poll();
			
			map[d.x][d.y] = cnt;
			v[d.x][d.y] = true;
			
			for(int i =0; i < 8; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > 9 || ny > 9 || v[nx][ny] || map[nx][ny] != 1) 
					continue;			
				q.add(new Data(nx, ny));
			}
		}
		cnt++;	
	}
	
	static class Data {
		int x, y;
		
		Data(int x, int y){
			this.x = x;
			this.y= y;
		}
	}
}
