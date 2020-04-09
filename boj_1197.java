import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1197 {
	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		rank = new int[V];
		int[][] edges = new int[E][3];
		for(int i =0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
			
		});
		
		for(int i =0; i < V; i++) {
			makeSet(i);
		}
		
		int cnt = 0;
		int result = 0;
		for(int i =0; i < E; i++) {
			int a = findSet(edges[i][0]-1);
			int b = findSet(edges[i][1]-1);
			if(a ==b)
				continue;
			union(a, b);
			result += edges[i][2];
			cnt++;
			if(cnt == V-1)
				break;
		}
		
		System.out.println(result);
	}
	
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x]) return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x ==y) return;
		if(rank[x] > rank[y]) {
			parents[y] = parents[x];
		}else
			parents[x] = parents[y];
			if(rank[x] == rank[y]) {
				rank[y]++;
			}
	}
}