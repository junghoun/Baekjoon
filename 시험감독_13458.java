import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독_13458 {
	static int[] ts;
	static int N, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		ts = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			ts[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long result = 0;
		
		for(int i =0; i < N; i++) {
			int val = ts[i] - B;
			result++;
			if(val <= 0) continue;
			
			if(val%C ==0) {
				result += val/C;
			}else {
				result += val/C;
				result++;
			}
		}
		
		System.out.println(result);
	}
}
