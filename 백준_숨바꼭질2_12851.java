import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_숨바꼭질2_12851 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int find_count = Integer.MAX_VALUE;
		
		boolean[] v = new boolean[100001];
		
		Queue<Data> q = new LinkedList<>();
		
		q.add(new Data(N, 0));
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int t = 0; t < size; t++) {
				Data d = q.poll();
				
				v[d.val] = true;				
				
				if(d.cnt > find_count)
					continue;

				
				if(d.val == K) {
					find_count = Math.min(find_count, d.cnt);
					if(find_count != d.cnt) continue;
					count++;

				}
				
				
				int temp = d.val -1;
				if(temp >=0 && !v[temp]) {
					q.add(new Data(temp, d.cnt+1));
				}
				
				
				temp = d.val +1;
				if(temp <=100000 && !v[temp]) {
					q.add(new Data(temp, d.cnt+1));
				}
				
				
				temp = d.val*2;
				if(temp <=100000 && !v[temp]) {
					q.add(new Data(temp, d.cnt+1));
				}
			
			}
			
		}
		
		System.out.println(find_count);
		System.out.println(count);
		
		
		}
	
	
	public static class Data {
		int val;
		int cnt;
		
		Data(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
}
