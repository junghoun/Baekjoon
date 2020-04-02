import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_조합_5607 {
	static final int MOD = 1234567891; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		long[] fact = new long[1000001];
		
		fact[1] = 1;
		
		for(int i =2 ; i <= 1000000; i++) {
			fact[i] = (i * fact[i-1])%MOD; 
		}
		
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			
			long A = fact[N];
			long B = (fact[R]*fact[N-R])% MOD;
			
			long result = A * pow(B, MOD-2) % MOD;
			
			sb.append("#" + t + " " + result + "\n");

		}
		System.out.println(sb);
	}
	
	static long pow(long b, long p) {
		long result = 1;
		long temp = b;
		
		while(p > 0) {
			if(p%2 ==1) result = result * temp % MOD;
			p = p/2;
			temp = (temp*temp)%MOD;
		}
		
		return result;
	}


	
}
