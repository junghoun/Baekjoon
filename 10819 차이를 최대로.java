import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static int[] arr;
	static boolean[] v;
	static int val = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		v = new boolean[N];
		result = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		solve(0);
		
		System.out.println(val);
		
	}
	
	private static void solve(int cnt){
		if(cnt == arr.length) {
			val = Math.max(val,  sum(result));
			return;
		}
		
		for(int i =0; i < arr.length; i++) { 
			if(v[i])
				continue;
			result[cnt] = arr[i];
			v[i] = true;
			solve(cnt+1);
			v[i] = false;
			
		}
		
	}
	
	private static int sum(int[] arr) {
		int result = 0;
		
		for(int i =0; i < arr.length-1; i++) {
			result += Math.abs((arr[i]-arr[i+1]));
		}
		
		return result;
		
	}
}