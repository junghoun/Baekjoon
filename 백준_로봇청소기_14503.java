import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_로봇청소기_14503 { 
	static int map[][];
	static boolean[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		v = new boolean[R][C];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i =0; i <R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		boolean flag = false;
		Queue<Robot> q = new LinkedList<>();
		q.add(new Robot(x,y,d));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			
			Robot r = q.poll();
			
			int dir = r.d;
			int nx, ny;
			flag = false;
			
			for(int i =0; i < 4; i++) {
				dir = find_dir(dir);
				nx = r.x+dx[dir];
				ny = r.y+dy[dir];
				
				if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || v[nx][ny] || map[nx][ny] == 1)
					continue;
				else {
					q.add(new Robot(nx, ny, dir));
					cnt++;
					v[nx][ny] = true;
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				dir = find_back(r.d);
				nx = r.x+dx[dir];
				ny = r.y+dy[dir];
				if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || map[nx][ny] == 1) {
					continue;
				}
				q.add(new Robot(nx, ny, r.d));
				
			}
		}
		
		System.out.println(cnt);
		
	}
	// 북 동 남 서
	public static int find_dir(int dir) {
		if(dir ==0) {
			return 3; 
		}else if(dir == 1) {
			return 0;
		}else if(dir == 2) {
			return 1;
		}else
			return 2;
	}
	
	public static int find_back(int dir) {
		if(dir == 0) {
			return 2;
		}else if(dir == 1)
			return 3;
		else if(dir == 2)
			return 0;
		else
			return 1;
	}
	
	public static class Robot {
		int x;
		int y;
		int d;
		
		Robot(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		
	}
}
