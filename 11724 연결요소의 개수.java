import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int cnt = 0;
		
		parent = new int[N+1];
		count = new int[N+1];
		
		makeSet();
		
		for(int t= 0; t< M; t++) {
			s = br.readLine().split(" ");
			int num1 = Integer.parseInt(s[0]);
			int num2 = Integer.parseInt(s[1]);
			union(num1, num2);
		}
		
		for(int i =1; i < parent.length; i++) {
			parent[i] = findSet(parent[i]);
		}
		
		for(int i =1; i <parent.length; i++) {
			count[parent[i]] = 1;
		}
		
		for(int i =1; i < count.length; i++) {
			if(count[i] == 1)
				cnt++;
		}
		
		System.out.println(cnt);
		

	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x ==y)
			return;
		parent[y] = x;
	}
	
	
	static int findSet(int x) {
		if(parent[x] == x)
			return x;
		
		int nx = findSet(parent[x]);
		parent[x] = nx;
		return nx;
	}
	
	static void makeSet() {
		for(int i =1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

}