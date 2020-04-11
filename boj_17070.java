import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17070 {
	static int[][] map;
	static int N, count;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i= 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		
		System.out.println(count);
		
		
	}
	// 0 : ㅡ , 1 : ㅣ, 2 : \
	static int[] findType(int type) {
       
		if(type == 0) {
			int[] t = {0, 2};
			return t;
		}
		if(type == 1) {
			int[] t = {1, 2};
			return t;
		}
		if(type == 2) {
			int[] t = {0, 1, 2};
			return t;
		}
		return null;
       
    }
	
    public static void dfs(int x, int y, int type){
        if(x==N-1 && y==N-1) {
            count++;
            return;
        }
        
        int t[] = findType(type);
        
        for(int i=0;i<t.length;i++) {
 
            int nx = x+dx[t[i]];
            int ny = y+dy[t[i]];
            
            if(nx > N-1 || ny > N-1 || map[nx][ny] != 0)
            	continue;
            if(t[i] ==2 && (map[nx-1][ny] != 0 || map[nx][ny-1] !=0))
            	continue;
            
            
            dfs(nx,ny,t[i]);
            
        }
        
    }
    
    
}
