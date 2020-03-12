import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int n;
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(arr[i][j] == 1)
					q.add(j);
			}
			
			while(!q.isEmpty()) {
				n = q.poll();
				
				arr[i][n] = 1;
				
				for(int idx =0; idx < N; idx++) {
					if(arr[i][idx] ==0 && arr[n][idx]==1) {
						q.add(idx);
					}
				}
			}
		}
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
}