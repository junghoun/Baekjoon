import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9466 {
	static int[] map;
	static int N, count;
	static boolean[] cycle, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			count = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			v = new boolean[N];
			cycle = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				if(!v[i])
					dfs(i);
			}

			System.out.println(N-count);
		}
	}

	static void dfs(int idx) {
		v[idx] = true;
		
		int next = map[idx];
		
		if(!v[next]) {
			dfs(next);
		}else {
			if(!cycle[next]) {
				count++;
				for(int i = next; i != idx; i = map[i])
					count++;
			}
		}
		
		cycle[idx] = true;
	}
}
