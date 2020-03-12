import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M;
	static int[] v = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		bfs();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		q.add(N);
		v[N] = 1;

		while (!q.isEmpty()) {
			
				N = q.poll();
				
				if(N == M) {
					
					break;
				}
				
				if (N+1 <= 100000 && v[N+1] ==0) {
					q.add(N+1);
					v[N+1] = v[N] +1;
				}
		
				if (N-1 >=0 && v[N-1] == 0) {
					q.add(N-1);
					v[N-1] = v[N] +1;
				}
				
				if (N*2 <= 100000 && v[N*2] ==0) {
					q.add(N*2);
					v[N*2] = v[N]+1;
				}
				
			}
		System.out.println(v[M]-1);
		}
	
}