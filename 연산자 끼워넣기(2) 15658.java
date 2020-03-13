import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num, oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		num = new int[N];
		oper = new int[4];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < 4; i++) { 
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(1, num[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int cnt, int result) {
		if(cnt ==num.length) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			
			return;
		}
		
		for(int i =0; i < 4; i++) { 
			if(oper[i] ==0)
				continue;
			oper[i]--;
			switch(i) {
			case 0:
				dfs(cnt+1, result+num[cnt]);
				break;
			case 1:
				dfs(cnt+1, result-num[cnt]);
				break;
			case 2:
				dfs(cnt+1, result*num[cnt]);
				break;
			case 3:
				dfs(cnt+1, result/num[cnt]);
				break;
			}
			oper[i]++;
		}
		
	}
	
}
