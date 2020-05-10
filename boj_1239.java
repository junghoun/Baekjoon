import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1239 {
	static int N, calc;
	static int[] temp, result, temp2;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		temp = new int[N];
		result = new int[N];
		temp2 = new int[N*2];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0);
		
		System.out.println(calc);
	}
	
	static void solve(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(result));
			solve2();
			return;
		}
		
		for(int i =0; i < N; i++) {
			if(v[i])
				continue;
			v[i] = true;
			result[cnt] = temp[i];
			solve(cnt+1);
			v[i] = false;
			
		}
		
	}
	
	static void solve2() {
		for(int i =0; i < N; i++) {
			temp2[i] = result[i];
		}
		
		for(int i = 0; i < N; i++) {
			temp2[i+N] = result[i];
		}
		
		int cnt = 0;
		for(int i =0; i < N; i++) {
			int sample = 0;
			for(int j =i; j < N*2; j++) {
				sample += temp2[j];
				
				if(sample == 50)
					cnt++;
				if(sample > 50)
					break;
			}
		}
		cnt /= 2;
		calc = (calc > cnt ? calc : cnt);
	}
}
