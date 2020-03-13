import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list[]; 
	static boolean[] v;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for(int i =0; i < N; i++) { 
			list[i] = new ArrayList();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list[num1].add(num2);
			list[num2].add(num1);
		}

		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			dfs(i, 0);
		}
		System.out.println(0);
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}
		v[idx] = true;
		for (int i = 0; i < list[idx].size(); i++) {
			if(v[list[idx].get(i)])
				continue;
			v[list[idx].get(i)] = true;
			dfs(list[idx].get(i), cnt + 1);
			v[list[idx].get(i)] = false;
		}
	}

	
	
}
