import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int M, N;
	static int cnt;
	static boolean[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		v = new boolean[M][N];
		int sx, sy, ex, ey;
		for(int i =0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken()); 
			ex = M - Integer.parseInt(st.nextToken()); 
			ey = Integer.parseInt(st.nextToken()); 
			sx = M - Integer.parseInt(st.nextToken());
			
			for(int j = sx; j < ex; j++) {
				for(int k = sy; k < ey; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i =0; i < M; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					dfs(i, j);
				}
			}
			
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for(int i : list) {
			System.out.print(i + " ");
		}
		
	}
	static void dfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		int count = 1;
		v[x][y] = true;
		q.add(new Data(x, y));
		Data d;
		int nx, ny;
		while(!q.isEmpty()) {
			d = q.poll();
			for(int i =0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || v[nx][ny] || map[nx][ny]!=0)
					continue;
				q.add(new Data(nx, ny));
				v[nx][ny] = true;
				count++;
			}
		}
		cnt++;
		list.add(count);
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