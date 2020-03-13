import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		v = new boolean[21];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("all")) {
				Arrays.fill(v, true);
				continue;
			}
			if(s.equals("empty")) {
				Arrays.fill(v, false);
				continue;
			}
			int num = Integer.parseInt(st.nextToken());
			
			if(s.equals("add")) {
				v[num] = true;
			}
			if(s.equals("remove")) {
				v[num] = false;
			}
			if(s.equals("check")) {
				if(v[num])
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			if(s.equals("toggle")) {
				v[num] = (v[num] == true) ? false : true; 
			}
		}
		System.out.println(sb);
		
	}
	
	
}