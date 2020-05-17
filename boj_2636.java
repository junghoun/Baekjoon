import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2636 {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Data> rq = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i =0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j <M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0, pre = 0, time = 0;
		Data rqq;
		while(true) {
			v = new boolean[N][M];
			fill();
			
			for(int i =1; i < N-1; i++) {
				for(int j =1; j< M-1; j++) {
					if(map[i][j] == 1 && check(i,j)) {
						bfs(i, j);
					}
				}
			}
			
			cnt = rq.size();
			if(cnt ==0) break;
			
			pre = cnt;
			time++;
			
			
			while(!rq.isEmpty()){
				rqq = rq.poll();
				map[rqq.x][rqq.y]= -1; 
			}
		}
		
		System.out.println(time);
		System.out.println(pre);
	}
	
	static void bfs(int x, int y) {
		Queue<Data> sq = new LinkedList<>();
		sq.add(new Data(x, y));
		
		while(!sq.isEmpty()) {
			Data d = sq.poll();
			
			v[d.x][d.y]= true;
			
			if(check(d.x,d.y)) {
				map[d.x][d.y]= 2;
				rq.add(new Data(d.x, d.y));
			}
			for(int i =0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || map[nx][ny] != 1 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				sq.add(new Data(nx, ny));
			}
		}
	}
	
	static boolean check(int x, int y) {
		for(int i =0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(map[nx][ny] == -1) return true;
		}
		return false;
	}
	
	static void fill() {
		
		boolean[][] ov = new boolean[N][M];
		ov[0][0] = true;
		
		Queue<Data> q = new LinkedList<>();
		
		q.add(new Data(0, 0));
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			map[d.x][d.y]= -1;
			
			for(int i =0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || map[nx][ny] > 0 || ov[nx][ny])
					continue;
				q.add(new Data(nx, ny));
				ov[nx][ny] = true;
			}
		}
	}
	
	static class Data {
		int x;
		int y;
		
		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
