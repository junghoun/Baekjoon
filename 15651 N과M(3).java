import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N,M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[M];
		
		
		solve(0);

		bw.flush();
		
	}

	static void solve(int cnt) throws IOException {
		if(cnt == M) {
			for(int i =0; i < M; i++) {
				bw.write(String.valueOf(arr[i] + " "));
			}
			bw.newLine();
			return;
		}
		
		for(int i = 0; i< N; i++) {
			arr[cnt] = i+1;
			solve(cnt+1);
		}
	}
	

}