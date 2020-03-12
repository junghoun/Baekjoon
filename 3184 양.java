import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int[] arr;
	static boolean[][] v;
	static int R, C, wolf, sheep;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");

		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		v = new boolean[R][C];
		
		for(int i =0; i < R; i++) {
			s = br.readLine().split("");
			for(int j =0; j < C; j++) {
				map[i][j] = s[j].charAt(0);
				if(map[i][j] == 'o') sheep++;
				if(map[i][j] == 'v') wolf++;
			}
		}
		
		for(int i =0; i < R; i++) {
			for(int j =0; j < C; j++) {
				if(map[i][j] != '#' && !v[i][j])
					bfs(i, j);
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int w = 0, s = 0;
		int nx, ny;
		Point p;
		
		v[x][y] = true;
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			p = q.poll();			
			if(map[p.x][p.y] == 'o' ) s++;
			if(map[p.x][p.y] == 'v' ) w++;
			for(int i =0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx < 0 || ny <0 || nx > R-1 || ny > C-1 || v[nx][ny] || map[nx][ny] == '#')
					continue;
				q.add(new Point(nx, ny));
				v[nx][ny]= true;
			}
		}

		if(s > w)
			wolf -=w;
		else
			sheep -= s;
	}
	
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}