import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num = 0;
		int e1, e2, e3;
		while(true) {
			num++;
			e1 = num%15;
			if(e1 ==0)	e1 = 15;
			if(e1 != E) continue;
			e2 = num%28;
			if(e2 == 0) e2 = 28;
			if(e2 != S) continue;
			e3 = num%19;
			if(e3 ==0)	e3 = 19;
			if(e3 == M) {
				System.out.println(num);
				break;
			}
			
			
		}
		
	}
	
	
	
}
