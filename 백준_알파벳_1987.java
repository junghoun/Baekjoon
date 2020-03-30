import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    
    static int N, M;
    static int[][] map;
    static boolean[] alp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 1, result = 1;
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        alp = new boolean[26];
        
        for(int i =0; i <N; i++) {
        	String s = br.readLine();
        	for(int j =0; j < M; j++) {
        		map[i][j] = s.charAt(j) - 'A';
        	}
        }
        
        dfs(0, 0);

        
        
        
        
        System.out.println(result);
        
     
    }
    
    static void dfs(int x, int y) {
    	alp[map[x][y]] = true;
    	
    	for(int i =0; i < 4; i++) { 
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx >= 0 && ny >= 0 && nx <N && ny < M && ! alp[map[nx][ny]]) {
    			result = Math.max(++cnt, result);
    			dfs(nx, ny);
    		}
    		
    	}
    	--cnt;
    	alp[map[x][y]] = false;
    }
}
