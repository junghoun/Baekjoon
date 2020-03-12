import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			long value = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N-1; i++) { 
				for(int j = i+1; j < N; j++) { 
					value += gcd(arr[i], arr[j]);
				}
			}
			
			System.out.println(value);
			
		}

	}

	private static int gcd(int x, int y) {
		while(y > 0) {
			int temp = y;
			y = x %y;
			x = temp;
		}
		
		return x;
	}
	
	
}