import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[N];
		v = new boolean[N];
		
		for(int i =0; i < N; i++) { 
			arr[i] = i+1;
		}
		solve(0);
		
		
	}
	
	static boolean flag;
	private static void solve(int cnt) {
		if(cnt == arr.length) {
			for(int i =0; i < cnt; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0; i < arr.length; i++) { 
			if(v[i])
				continue;
			v[i] = true;
			result[cnt] = i+1;
			solve(cnt+1);
			v[i] = false;
		}
	}
	
}