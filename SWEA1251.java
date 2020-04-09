import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Kruskal
public class SWEA1251 {
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		long val;
		
		Edge(int x, int y, long val){
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			
			return Long.compare(this.val, o.val);
		}
	}
	
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stx, sty;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			
			stx = new StringTokenizer(br.readLine());
			sty = new StringTokenizer(br.readLine());
			
			for(int i =0; i < N; i++) {
				arr[i][0] = Integer.parseInt(stx.nextToken());
				arr[i][1] = Integer.parseInt(sty.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			Edge[] edges = new Edge[N*(N-1)/2];
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					edges[cnt++] = new Edge(i, j, calc(arr[i][0], arr[i][1], arr[j][0], arr[j][1]));
				}
			}
			
			Arrays.sort(edges);
			
			parents = new int[N];
			makeSet();
			
			long result = 0;
			cnt = 0;
			
			for(int i =0; i < N*(N-1)/2; i++) {
				int a = findSet(edges[i].x);
				int b = findSet(edges[i].y);
				if(a == b) continue;
				
				union(a, b);
				cnt++;
				result += edges[i].val;
				if(cnt == N-1)
					break;
			}
			
			System.out.println("#" + t + " " + Math.round(result * E));
		}
		
	}
	
	static long calc(long sx, long sy, long ex, long ey) {
		return (long)(Math.pow(sx-ex, 2) + Math.pow(sy-ey, 2));
	}
	
	static void makeSet() {
		for(int i =0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x ==y) return;
		
		if( x < y)
			parents[y] = x;
		else
			parents[x] = y;
 	}
	
	static int findSet(int x) {
		if(parents[x] == x) return x;
		
		
		return parents[x] = findSet(parents[x]);
		
	}
}
