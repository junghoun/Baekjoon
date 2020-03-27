import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_종교_1863 {
	static int[] parent;
	static int[] count;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		count = new int[N];
		cnt = N;
		makeSet();
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			union(num1, num2);
		}
		System.out.println(cnt);
	}
	
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x ==y)
			return;
		cnt--;
		parent[y] = x;
	}
	
	static void makeSet() {
		for(int i =1; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = findSet(parent[x]);
	}
}
