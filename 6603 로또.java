import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] result = new int[6];
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			arr = new int[N];
			for(int i =0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println();
			
		}
		
	}
	
	static void dfs(int begin, int cnt) {
		if(cnt == result.length) {
			for(int i =0; i<6; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = begin; i < arr.length; i++) {
			result[cnt] = arr[i];
			dfs(i+1, cnt+1);
		}
	}
}