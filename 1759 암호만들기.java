import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] map, result;
	static boolean[] v;
	static int[] collection = {97, 101, 105, 111, 117};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		result = new int[L];
		map = new int[C];
		v = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < C; i++) { 
			map[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(map);
		solve(0, 0, 0, 0);
	}

	private static void solve(int start, int cnt, int col, int con) {
		if(cnt == result.length) {
			if(col ==0 || con < 2)
				return;
			for(int i =0; i < cnt; i++) {
				System.out.print((char)result[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i =start; i < map.length; i++) { 
			if(v[i])
				continue;
			result[cnt] = map[i];
			v[cnt] = true;
			if(map[i] == 97 || map[i] == 101 || map[i] == 105 || map[i] == 111 || map[i] == 117)
				solve(i+1, cnt+1, col+1, con);
			else
				solve(i+1, cnt+1, col, con+1);
			v[cnt] = false;
			
		}
	}

}