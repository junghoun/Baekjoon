import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		v = new int[N+1][N+1];
		
		for(int i =0; i <= N; i++) {
			Arrays.fill(v[i], -1);
		}
		
		Queue<Data> q = new LinkedList<>();
		
		q.add(new Data(1, 0));
		v[1][0] = 0;
		while(!q.isEmpty()) {

			Data d = q.poll();
			
			
			
			if(v[d.cnt][d.cnt]== -1) {
				v[d.cnt][d.cnt]= v[d.cnt][d.temp] +1;
				q.add(new Data(d.cnt, d.cnt));
			}
			
			if(d.cnt + d.temp <= N && v[d.cnt+d.temp][d.temp]== -1 ) {
				v[d.cnt+d.temp][d.temp] = v[d.cnt][d.temp]+1;
				q.add(new Data(d.cnt+d.temp, d.temp));
			}
			
			if(d.cnt-1 >= 0 && v[d.cnt-1][d.temp]== -1 ) {
				v[d.cnt-1][d.temp]= v[d.cnt][d.temp]+1;
				q.add(new Data(d.cnt-1, d.temp));
			}
		}
		
		
		int result = -1;
		
		for(int i =0; i <= N; i++) {
			if(v[N][i] != 0) {
				if(result == -1 || result > v[N][i])
					result = v[N][i];
			}
		}
		
		System.out.println(result);
		
		
		
	}
	
	static class Data {
		int cnt;
		int temp;
		
		Data(int cnt, int temp) {
			this.cnt = cnt;
			this.temp = temp;
		}
	}
	
}
