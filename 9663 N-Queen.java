import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int cnt = 0;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		
		map = new int[N][N];
		
		dfs(0);

		System.out.println(cnt);
	}
	
	static void dfs(int level) {
		if(level == N) {
			cnt++;
			return;
		}
		
		for(int j =0; j < N; j++) {
			if(isPromming(level, j)) {
				map[level][j] = 1;
				dfs(level+1);
				map[level][j] = 0;
			}
		}
	}
	
	static boolean isPromming(int level, int c) {
//		|
		for(int i = level-1; i >= 0; i--) {
			if(map[i][c] == 1)
				return false;
		}
//		\
		for(int i = level-1, j = c-1; i >=0 && j >= 0 ; i--,j--) {
			if(map[i][j] == 1)
				return false;
		}
//		/
		for(int i = level-1, j = c+1; i >= 0 && j < N; i--, j++) {
			if(map[i][j] == 1)
				return false;
		}
		
		return true;
	}
}