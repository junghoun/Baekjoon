import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13460 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result;
	static Data data;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[10][10][10][10];
		data = new Data();
		data.cnt = 0;
		
		for(int i =0; i < N; i++) {
			String s = br.readLine();
			for(int j =0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'R') {
					data.rx = i;
					data.ry = j;
				}
				if(map[i][j] == 'B') {
					data.bx = i;
					data.by = j;
				}
			}
		} 
		
		bfs();
		System.out.println(result);
			
	}
	
	static void bfs() {
		Queue<Data> q = new LinkedList<>();
		q.add(data);
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			
			v[d.rx][d.ry][d.bx][d.by] = true;
			
			if(d.cnt >= 10) {
				result = -1;
				return;
			}
			
			for(int i =0; i < 4 ; i++) {
				int nbx = d.bx;
				int nby = d.by;
				while(map[nbx + dx[i]][nby + dy[i]] != '#') {
					nbx += dx[i];
					nby += dy[i];
					if(map[nbx][nby] == 'O')
						break;
				}
				
				int nrx = d.rx;
				int nry = d.ry;
				while(map[nrx + dx[i]][nry + dy[i]] != '#') {
					nrx += dx[i];
					nry += dy[i];
					if(map[nrx][nry] == 'O')
						break;
				}
				
				if(map[nbx][nby] == 'O')
					continue;
				
				if(map[nrx][nry] == 'O') {
					result = d.cnt +1;
					return;
				}
				
				if(nrx == nbx && nry == nby) {
					switch(i) {
					case 0:		//북
						if(d.rx > d.bx) nrx+=1;
						else 			nbx+=1;
						break;
					case 1:		//동
						if(d.ry > d.by) nby-=1;
						else 			nry-=1;
						break;
					case 2:		//남
						if(d.rx > d.bx) nbx-=1;
						else			nrx-=1;
						break;
					case 3:		//서
						if(d.ry > d.by) nry+=1;
						else			nby+=1;
						break;
					}
				}
				
				if(!v[nrx][nry][nbx][nby])
					q.add(new Data(nrx, nry, nbx, nby, d.cnt+1));
			}
		}
		result = -1;
	}
	
	static class Data {
		int rx, ry, bx, by, cnt;
		
		Data(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}

		public Data() {
			// TODO Auto-generated constructor stub
		}
	}
}
