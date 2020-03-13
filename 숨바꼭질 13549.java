import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] subin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		subin = new int[100001];
		
		Arrays.fill(subin, -1);
		
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(N, 0));
back:	while(!q.isEmpty()) {
			
			int size = q.size();
			for(int t = 0; t < size; t++) {
				Data d = q.poll();
				
				if(d.value == K) {
					subin[d.value] = d.cnt; 
					break back;
				}
				
				if(subin[d.value] != -1 )
					continue;
				subin[d.value] = d.cnt;
				
				if(d.value-1 >= 0 && subin[d.value-1] == -1) {
					q.add(new Data(d.value-1, d.cnt+1));
				}
				
				if(d.value*2 < subin.length && subin[d.value*2] ==-1) {
					q.add(new Data(d.value*2, d.cnt));
					
				}
				
				if(d.value+1 < subin.length && subin[d.value+1] ==-1) {
					q.add(new Data(d.value+1, d.cnt+1));
					
				}
				
				
				
			}
			
		}
		if(subin[K] == -1)
			System.out.println(0);
		else
			System.out.println(subin[K]);
		
		
		
	}
	
	static class Data {
		int value;
		int cnt;
		
		Data(int value, int cnt){
			this.value = value;
			this.cnt = cnt;
		}
	}
	
}
