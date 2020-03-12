import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for(int t= 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i =0; i < M; i++) {
				st = new StringTokenizer(br.readLine());				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(N-1);
		}
	}

	
}