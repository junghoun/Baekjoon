import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17142 {
	static int N, M, zero, result = Integer.MAX_VALUE;
	static int[][] map, temp;
	static boolean[] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0 , -1};
	static ArrayList<Virus> list = new ArrayList<>();;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					list.add(new Virus(i, j));
				if(map[i][j] == 0)
					zero++;
			}
		}
		
		v = new boolean[list.size()];
		
		if(zero != 0)
			dfs(0, 0);
		else
			result = 0;
		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}
	
	static void dfs(int cnt, int start) {
		if(cnt == M) {
			temp = new int[N][N];
			for(int i =0; i < N; i++) {
				System.arraycopy(map[i], 0, temp[i], 0, N);
			}
			for(int i =0; i < list.size(); i++) {
				if(!v[i]) {
					temp[list.get(i).x][list.get(i).y] = -1;
				}
					
			}
			bfs();
			return;
		}
		
		for(int i =start; i < list.size(); i++) {
			v[i] = true;
			dfs(cnt+1, i+1);
			v[i] = false;
		}
	}
	
	static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		int count = zero;
		for(int i =0; i < list.size(); i++) {
			if(v[i])
				q.add(list.get(i));
		}
		
		int time = 0, nx, ny;
		while(!q.isEmpty()) {
			if(result <= time) break;
			
			int size = q.size();
			for(int t =0; t < size; t++) {
				Virus v = q.poll();
				for(int i =0; i < 4; i++) {
					nx = v.x + dx[i];
					ny = v.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || temp[nx][ny] == 1 || temp[nx][ny] == 2)
						continue;
					
					if(temp[nx][ny] == 0) count--;	
					temp[nx][ny] = 2;
					q.add(new Virus(nx, ny));
				}
			}
			time++;
			
			if(count == 0) {
				result = time;
				return;
			}
		}
	}
	
	static class Virus {
		int x;
		int y;
		
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
