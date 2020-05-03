import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1405 {
	static double[] dir = new double[4];
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static double result;
	static boolean[][] v=  new boolean[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for(int i =0; i < 4; i++) {
			dir[i] = Double.parseDouble(st.nextToken()) / 100;
		}
		
		dfs(0, new Data(15, 15), 1);
		
		System.out.println(result);
	}
	
	static void dfs(int idx, Data d, double per) {
		if(idx == N) {
			result += per;
			return;
		}
		
		v[d.x][d.y]= true; 
		for(int i =0; i < 4; i++) {
			int nx = d.x + dx[i];
			int ny = d.y + dy[i];
			if(!v[nx][ny])
				dfs(idx+1, new Data(nx, ny), dir[i] * per);
		}
		v[d.x][d.y]= false; 
		
		
	}
	
	
	static class Data{
		int x;
		int y;
		
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
	
	
