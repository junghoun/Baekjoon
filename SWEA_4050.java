import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_4050 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int  t= 1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Integer[] map = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(map, Collections.reverseOrder());
			
			Long result = 0L;
			for(int i =0; i < N/3; i++) {
				result += map[i*3] + map[i*3+1];
			}
			
			if(N%3==1)
				result += map[N-1];
			if(N%3==2)
				result += map[N-1] + map[N-2];			

			System.out.println("#" + t + " " + result);
		}
	}
}
