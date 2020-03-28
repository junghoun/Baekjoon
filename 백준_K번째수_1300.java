import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_K번째수_1300 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int low = 1;
		int high = K;
		int answer = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			int sum = 0;
			for(int i =1; i <= N; i++)
				sum += Math.min(mid/i, N);
			
			if(sum >= K) {
				high = mid-1;
				answer = mid;
			}else
				low = mid+1;
				
		}
		System.out.println(answer);
	}

		

}