import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {
	static int[] arr;
	static boolean[] v;
	static int F,S,G,U,D, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[F+1];
		v = new boolean[F+1];
		Arrays.fill(arr, -1);
		
		bfs(S);
		
		if(arr[G]==-1 && S!= G) {
			System.out.println("use the stairs");
		}else {
			System.out.println(arr[G]+1);
		}
		
		
		
	}
	
	static void bfs(int s){
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		v[s] = true;
		
		while(!q.isEmpty()) {
			count++;
			int f = q.poll();
			
			if(f == G) return;
			
			if(f+U <= F && !v[f+U]) {
				q.add(f+U);
				arr[f+U] = arr[f] +1;
				v[f+U]= true;
			}
			
			if(f-D >= 1 && !v[f-D]) {
				q.add(f-D);
				arr[f-D] = arr[f] +1;
				v[f-D] = true;
			}
		}
	}
}
