import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 백준_녹색옷입은애가젤다지1_4485 {
	static int[][] map, result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        int pi = 1;
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	if(N ==0)
        		break;
        	map = new int[N][N];
        	result = new int[N][N];
  
        	for(int i=0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		Arrays.fill(result[i], Integer.MAX_VALUE);
        		for(int j =0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	bfs(0, 0);
        	
        	System.out.printf("Problem %d: %d\n", pi++, result[N-1][N-1]);
        }
    }
    
    
    static void bfs(int x, int y) {
    	Queue<Data> q = new LinkedList<>();
    	q.add(new Data(x, y));

    	result[x][y] = map[x][y];
    	while(!q.isEmpty()) {
    		Data d = q.poll();
    		
    		for(int i=0; i < 4; i++) {
    			int nx = d.x + dx[i];
    			int ny = d.y + dy[i];
    			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || result[nx][ny] <= result[d.x][d.y]+ map[nx][ny] ) {
    				continue;
    			}

    			result[nx][ny] = result[d.x][d.y]+ map[nx][ny]; 

    			q.add(new Data(nx, ny));
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
