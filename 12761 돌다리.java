import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[100001];
	static int A,B, N, M;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		q.add(N);
		int n;
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n == M)
				break;
			int nx;
			for(int i =0; i < 8; i++) {
				nx = move(n, i);
				if(nx <0 || nx > 100000 || arr[nx] != 0)
					continue;
				arr[nx] = arr[n]+1;
				q.add(nx);
			}
		}
		
		System.out.println(arr[M]);
		
	}
	static int move(int n, int idx) {
		int result = 0;
		switch(idx) {
		case 0 : result = n + 1; break;
		case 1 : result = n - 1; break;
		case 2 : result = n + A; break;
		case 3 : result = n + B; break;
		case 4 : result = n - A; break;
		case 5 : result = n - B; break;
		case 6 : result = n * A; break;
		case 7 : result = n * B; break;
		}
		
		return result;
	}
	
}