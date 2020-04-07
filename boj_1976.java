import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1976 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		makeSet();
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1 && i < j) {
					union(i+1, j+1);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		
		int result[] = new int[M];
		for(int i =0; i < M; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		for(int i =0; i < M-1; i++) {
			if(findSet(result[i]) != findSet(result[i+1])) {
				flag = false;
				break;
			}
			
		}
		
		
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	
	static void makeSet() {
		for(int i =1; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x ==y) return;
		
		if(x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		
		
		return parent[x] = findSet(parent[x]);
	}
	
}
