import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] v = new boolean[MAX+1];
		v[0] = v[1] = false;
		
		for(int i =2; i <= MAX; i++) { 
			v[i] = true;
		}
		for(int i =2; i*i <= MAX; i++) { 
			for(int j =i*i; j<= MAX; j+=i) { 
				v[j] = false;
			}
		}
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			
			boolean flag = false;
			for(int i = 2; i <= N/2; i++) { 
				if(v[i] && v[N-i]) {
					flag = true;
					System.out.println(N + " = " + i + " + " + (N-i));
					break;
				}
			}
			
			if(!flag)
				System.out.println("Goldbach's conjecture is wrong.");
			
		}
	}
	
	
	
}