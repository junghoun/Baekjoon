import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3190 {
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int dir = 1;
	static Queue<Data> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i =0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		
		map[0][0] = 1;
		q.add(new Data(0, 0));
		
		int L = Integer.parseInt(br.readLine());
		
		int[][] temp = new int[L][2];
		char c = ' ';
		for(int i =0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = st.nextToken().charAt(0);
			
		}
		
		int cnt = 1, idx = 0;
		int nx = 0, ny = 0;
		Data d;
		while(true) {
			
			for(int i =0; i < N; i++) {
				for(int j =0; j < N; j++) {
					System.out.print(map[i][j] + " " );
				}
				System.out.println();
			}
			System.out.println();
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if(nx <0 || ny < 0 || nx > N-1 || ny >N-1 || map[nx][ny] == 1)
				break;
			
			cnt++;
			
			if(map[nx][ny] != 2) {
				d = q.poll();
				map[d.x][d.y] = 0; 
			}
			
			map[nx][ny] = 1;
			q.add(new Data(nx, ny));
			
			if(idx < L && cnt == temp[idx][0]+1) {
				dir = changeDir(dir, temp[idx][1]);
				idx++;
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
	

	
	// 0: 북  1: 동  2: 남  3:서
	static int changeDir(int dir, int c) {
		if(c == 76) {
			if(dir == 0)
				return 3;
			else
				return dir-1;
		}
		else {
			if(dir == 3)
				return 0;
			else
				return dir+1;
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
