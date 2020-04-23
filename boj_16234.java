import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234 {
	static int N,L,R, cnt;
	static int[][] map, v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int result = 0;
		
		while(true) {
			
			v = new int[N][N];
			cnt = 0;
			boolean flag = false;
			
			
			for(int i =0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(v[i][j] == 0) {
						if(bfs(i, j))
							flag = true;
					}
				}
			}
			if(flag) result++;
			else
				break;
			
		}
		
		System.out.println(result);
		
	}
	
	static boolean bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		cnt++;
		q.add(new Data(x, y));
		v[x][y] = cnt;
		
		int sum = map[x][y];
		int sumCnt = 1;
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			
			for(int i =0; i <4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny >N-1 || v[nx][ny] != 0 || !boder(map[d.x][d.y], map[nx][ny]))
					continue;
				
				v[nx][ny] = cnt;
				sumCnt++;
				sum += map[nx][ny];
				q.add(new Data(nx, ny));
			}
		}
		
		if(sumCnt == 1) return false;
		else {
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(v[i][j] == cnt) {
					map[i][j] = sum / sumCnt;
				}
			}
		}
		return true;
		}
	}
	
	static boolean boder(int x, int y) {
		int diff = Math.abs(x-y);
		
		if(diff >= L && diff <= R)
			return true;
		else
			return false;
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
