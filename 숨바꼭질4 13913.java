import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] v;
	static Stack<Integer> s = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new int[100001];
		Arrays.fill(v, -1);
		
		bfs();
	}
	
	static void bfs() {
		Queue<Data> q = new LinkedList<>();
		
		q.add(new Data(N, 0));
		
back:	while(!q.isEmpty()) {
			int size = q.size();
			
			for(int t = 0; t<size; t++) {
			Data d = q.poll();
			
			if(d.val == M) {
				System.out.println(d.cnt);
				
				s.add(d.val);
				 while(M!=N) {
	                    s.add(v[M]);
	                    M = v[M];
	                }
				while(!s.isEmpty()) {
					System.out.print(s.pop() + " ");
				}
				
				break back;
			}
			
			int temp = d.val-1;
			if(temp >=0 && v[temp] == -1) {
				q.add(new Data(temp, d.cnt+1));
				v[temp] = d.val;
			}
			temp = d.val+1;
			if(temp <= 100000 && v[temp] == -1) {
				q.add(new Data(temp, d.cnt+1));
				v[temp] = d.val;
			}
			
			temp = d.val*2;
			if(temp <= 100000 && v[temp] == -1) {
				q.add(new Data(temp, d.cnt+1));
				v[temp] = d.val;
			}
		}
	}
}
	
	static class Data {
		int val;
		int cnt;
		
		Data(int val, int cnt){
			this.val = val;
			this.cnt = cnt;
		}
	}
}
