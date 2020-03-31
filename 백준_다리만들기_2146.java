import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 백준_다리만들기_2146 {
    static int N;
    static int[][] map;
    static boolean[][]v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int temp =2;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        
        
        map = new int[N][N];
        v = new boolean[N][N];
        
        for(int i =0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j =0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i =0; i < N; i++) {
        	for(int j=0; j < N; j++) {
        		if(map[i][j] == 1) {
        			bfs(i, j);
        			temp++;
        		}
        	}
        }
        for(int i=0; i < N; i++) {
        	Arrays.fill(v[i], false);
        }
        
        for(int i =0; i < N; i++) {
        	for(int j =0; j < N; j++) {
        		if(map[i][j] != 0) {
        			bfs2(i,j);
        		}
        	}
        }
        
        System.out.println(min);
    }
    
    static void bfs2(int x, int y) {
    	int cnt = 0;
    	Queue<Data> q = new LinkedList<>();
    	q.add(new Data(x, y));
    	v = new boolean[N][N];
    	v[x][y] = true;
    	int val = map[x][y];
    	
back:  	while(!q.isEmpty()) {
    		int size = q.size();
    		for(int t =0; t < size; t++) {
    			Data d = q.poll();
    			
    			if(map[d.x][d.y]!= val && map[d.x][d.y] > 0) {
    				min = Math.min(min,  cnt-1);
    				break back;
    			}
    			
    			for(int i =0; i < 4; i++) {
    				int nx = d.x + dx[i];
    				int ny = d.y + dy[i];
    				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || map[nx][ny] == val || v[nx][ny])
    					continue;
    				v[nx][ny] = true;
    				q.add(new Data(nx, ny));
    				
    				
    			}
    		}
    		cnt++;
    	}
    	
    }
    
    
    
    
    static void bfs(int x, int y) {
    	Queue<Data> q = new LinkedList<>();
    	q.add(new Data(x, y));
    	map[x][y] = temp;
    	v[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		
    		Data d = q.poll();
    		
    		for(int i =0; i < 4; i++) {
    			int nx = d.x + dx[i];
    			int ny = d.y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || v[nx][ny] || map[nx][ny] ==0)
    				continue;
    			map[nx][ny] = temp;
    			v[nx][ny] = true;
    			q.add(new Data(nx, ny));
    		}
    	}
    }
    
    static class Data{
    	int x;
    	int y;
    	Data (int x, int y){
    		this.x = x;
    		this.y = y;
    		
    		
    	}
    }
}
