import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7194 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int tt = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append("#" + t + " ");
			
			
			int result = 0;
			
			if(b > 1) {
				while(tt > s) {
					if (tt % b == 0 && tt/b >= s) {
						tt /= b;
						result++;
					} else {
						tt -= a;
						result++;
					}
				}
				if(tt != s)
					result = -1;
			}
			else {
				int val = tt-s;
				if(val % a == 0) {
					result = val/a;
				}else
					result = -1;
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}

}