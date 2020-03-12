import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[M];
		
		
		solve(0, 0);

		
	}

	static void solve(int start, int cnt){
		if(cnt == M) {
			for(int i =0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i< N; i++) {
			arr[cnt] = i+1;
			solve(start, cnt+1);
			start++;
		}
	}
	

}