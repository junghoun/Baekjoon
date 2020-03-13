import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, result;
	static boolean[] v;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		solve(0);
		System.out.println(sb);
	}
	
	private static void solve(int cnt) {
		if(cnt == M) {
			for(int i =0; i < M; i++) { 
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) { 
			if(v[i])
				continue;
			v[i] = true;
			result[cnt] = arr[i];
			solve(cnt+1);
			v[i] = false;
		}
	}
	
}