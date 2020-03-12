import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int N, M;
	static int cnt = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Data> q = new LinkedList<>();
	static Queue<Data> w = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new char[N][M];

		for(int i =0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j =0; j < M; j++) { 
				map[i][j] = ch[j];
				if(ch[j] == 'S')
					q.add(new Data(i, j));
				if(ch[j] == '*')
					w.add(new Data(i, j));
			}
		}
		bfs();
		
	}

	static void bfs() {
		
		while(true) {
			++cnt;
			if(q.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}
			
			int size = w.size();
			int nx, ny;
			Data d;

		    for (int i = 0; i < size; i++) {
		        d = w.poll();
		 
		        for (int j = 0; j < 4; j++) {
		            nx = d.x + dx[j];
		            ny = d.y + dy[j];
		 
		            if (nx >=0 && ny >= 0 && nx < N && ny < M) {
		                if (map[nx][ny] == '.') {
		                    map[nx][ny] = '*';
		                    w.add(new Data(nx, ny));
		                }
		            }
		        }
		    }
		    
		    size = q.size();
		    
		    for (int i = 0; i < size; i++) {
		        d = q.poll();
		 
		        for (int j = 0; j < 4; j++) {
		            nx = d.x + dx[j];
		            ny = d.y + dy[j];
		 
		            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
		                if (map[nx][ny] == 'D') {
		                    q.add(new Data(ny, nx));
		                    System.out.println(cnt);
		                    return;
		                }
		                if (map[nx][ny] == '.') {
		                    map[nx][ny] = 'S';
		                    q.add(new Data(nx, ny));
		                }
		            }
		        }
		    }
		}
		
	}
	
	static class Data {
		int x;
		int y;
		
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}