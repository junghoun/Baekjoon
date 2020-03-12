import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[M];
		v = new boolean[N];
		solve(0, 0);
		
	}

	static void solve(int start, int cnt) {
		if(cnt == M) {
			for(int i =0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i< N; i++) {
			if(v[i])
				continue;
			v[i] = true;
			arr[cnt] = i+1;
			solve(i+1, cnt+1);
			v[i] = false;
		}
	}
	

}