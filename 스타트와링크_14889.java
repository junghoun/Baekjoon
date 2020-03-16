import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
	static int map[][];
	static int N, min = Integer.MAX_VALUE;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		
		
		for(int i =1; i <= N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0);
		
		System.out.println(min);
	}
	
	static void solve(int start, int cnt) {
		if(cnt == N/2) {
			min = Math.min(min, find());
			return;
		}
		
		for(int i =start; i <= N; i++) {
			if(v[i]) continue;
			v[i] = true;
			solve(i+1, cnt+1);
			v[i] = false;
		}
	}
	
	static int find() {
		int start = 0;
		int link = 0;
		
		for(int i =1; i <=N; i++) {
			for(int j =1; j<= N; j++) {
				if(v[i] && v[j]) {
					start += map[i][j];
				}
				if(!v[i] && !v[j]) {
					link += map[i][j];
				}
			}
		}
		
		
		return Math.abs(start - link);
	}
}
