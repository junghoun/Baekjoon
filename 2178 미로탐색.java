import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		map = new int[N][M];
		v = new boolean[N][M];
		String s;
		for(int i =0; i < N; i++) {
			s = sc.next();
			for(int j =0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
	}
	
	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		
		v[x][y] = true;
		q.offer(new Data(x, y, 1));
		
		int nx,ny;
		Data d;
		while(!q.isEmpty()) {
			d = q.poll();
			for(int i =0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || v[nx][ny] || map[nx][ny] == 0) continue;
				
				if (nx == map.length - 1 && ny == map[0].length - 1) {
					System.out.println(d.cnt + 1);
					return;
				}
				
				v[nx][ny] = true;
				q.offer(new Data(nx, ny, d.cnt+1));
			}
		}
	}
	
	static class Data{
		int x;
		int y;
		int cnt;
		
		Data(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}