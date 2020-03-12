import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static boolean[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int max = 0, result = 0;
		
		for(int i =0; i < N ;i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
			}
		}
		
		for(int i = 0; i <= max; i++) {
			v = new boolean[N][N];
			cnt = 0;
			for(int j =0; j < N; j++) {
				for(int k =0; k < N; k++) {
					if(map[j][k] > i && !v[j][k]) {
						dfs(j, k, i);
						cnt++;
					}
				}
			}
			if(result < cnt )
				result = cnt;
		}
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int h) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));
		v[x][y] = true;
		int nx, ny;
		Data d;
		
		while(!q.isEmpty()) {
			d = q.poll();
			for(int i =0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || v[nx][ny] || map[nx][ny] <= h)
					continue;
				q.add(new Data(nx, ny));
				v[nx][ny] = true;
			}
		}
	}
	
	static class Data {
		int x, y;
		
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}