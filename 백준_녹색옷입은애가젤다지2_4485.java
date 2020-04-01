import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class 백준_녹색옷입은애가젤다지2_4485 {
	static int[][] map, result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static PriorityQueue<Data> pq;
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
        	pq = new PriorityQueue<>();
  
        	for(int i=0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		Arrays.fill(result[i], Integer.MAX_VALUE);
        		for(int j =0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	result[0][0] = 0;
        	pq.add(new Data(0, 0, map[0][0]));
        	
        	bfs();
        	
        	System.out.printf("Problem %d: %d\n", pi++, result[N-1][N-1]);
        }
    }
    
    
    static void bfs() {
    	
    	while(!pq.isEmpty()) {
    		Data d = pq.poll();
    		
    		for(int i=0; i < 4; i++) {
    			int nx = d.x + dx[i];
    			int ny = d.y + dy[i];
    			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || result[nx][ny] <= result[d.x][d.y]+ map[nx][ny] ) {
    				continue;
    			}

    			result[nx][ny] = d.val+ map[nx][ny]; 

    			pq.add(new Data(nx, ny, result[nx][ny]));
    		}
    	}
    }
    
    
    static class Data implements Comparable<Data>{
    	int x;
    	int y;
    	int val;
    	Data(int x, int y, int val){
    		this.x = x;
    		this.y = y;
    		this.val = val;
    	}
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.val <=o.val ? -1 : 1;
		}
    }
}
