import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1717 {
	static int[] parents;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i =0; i < N+1; i++) {
			parents[i] = i;
		}
		
		int type, num1, num2;
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			if(type == 0)
				union(num1, num2);
			else {
				int x=  findSet(num1);
				int y = findSet(num2);
				if(x==y)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
				
		}
		System.out.println(sb);
		
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x == y) return;
		
		parents[y] = x;
	}
	
	static int findSet(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = findSet(parents[x]);
	}
}
