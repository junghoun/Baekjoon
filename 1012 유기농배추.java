import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int c = sc.nextInt();
			map = new int[x][y];
			count = 2;
			
			for(int i =0; i < c; i++) {
				int yy = sc.nextInt();
				int xx = sc.nextInt();
				map[xx][yy] = 1;
			}
			
			for(int i =0; i < x; i++) {
				for(int j =0; j <y; j++) {
					if(map[i][j] ==1)
						bfs(i, j);
				}
			}
			System.out.println(count-2);
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));
		map[x][y] = count;
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			int nx, ny;
			for(int i =0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx <0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || map[nx][ny] != 1)
					continue;
				map[nx][ny] = count;
				q.add(new Data(nx, ny));
				
			}
		}
		count++;
	}
	
	static class Data{
		int x;
		int y;
		
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}