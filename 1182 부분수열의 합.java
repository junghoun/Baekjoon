import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] map;
	static boolean[] v;
	static int S, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) { 
			map[i] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		
		if(S ==0)
			System.out.println(count-1);
		else
			System.out.println(count);
	}

	
	private static void solve(int cnt) {
		if(cnt == map.length) {
			int sum = 0;
			for(int i =0; i < cnt; i++) {
				if(v[i])
					sum += map[i];
			}
			if(sum == S)
				count++;
			return;
		}
		
		v[cnt] = true;
		solve(cnt+1);
		
		v[cnt] = false;
		solve(cnt+1);
	}

}