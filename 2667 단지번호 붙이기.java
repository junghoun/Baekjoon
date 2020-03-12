import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int cnt = 2;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int i =0; i < N; i++) {
			String s = sc.next();
			for(int j =0; j < N; j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
				
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] == 1) 
					bfs(i, j);
			}
		}
		
		Collections.sort(list);
		System.out.println(cnt-2);
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		int count = 0;
		q.add(new Data(x, y));
		map[x][y] = cnt;
		
		while(!q.isEmpty()) {
			count++;
			Data d = q.poll();
			int nx, ny;
			
			for(int i =0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || map[nx][ny] != 1)
					continue;
				map[nx][ny] = cnt;
				q.add(new Data(nx,ny));
			}
		}
		list.add(count);
		cnt++;
		
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