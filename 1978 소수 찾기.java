import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			
			if(N <=1)
				flag = false;
			
			for(int i = 2; i <= N/2; i++) {
				if(N%i ==0) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				count++;
			
		}
		System.out.println(count);

	}

	
	
}