import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_단어수학_1339 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int alp[] = new int[26];
		
		for(int i =0; i < N; i++) { 
			String s = br.readLine();
			int mul = 1;
			for(int t = s.length()-1; t >=0; t--) { 
				alp[s.charAt(t)-'A'] += mul;
				mul *=10;
			}
			
		}
		Arrays.sort(alp);
		
//		System.out.println(Arrays.toString(alp));
		int result = 0;
		int mul = 9;
		for(int i =25; i >=0 ; i--) {
			if(alp[i] ==0) continue;
			result += alp[i]*(mul--);
		}
		
		System.out.println(result);
	}

	
}