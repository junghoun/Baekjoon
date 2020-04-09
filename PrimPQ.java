import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQ {
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] list = new ArrayList[V];
		for(int i =0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(start, end, cost));
			list[end].add(new Edge(end, start, cost));
		}
		
		boolean[] v=  new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] p = new int[V];
		//int[] dist = new int[V];
		p[0] = -1;
		pq.addAll(list[0]);
		
		v[0] = true;
		int cnt = 1;
		int result = 0;
		while(V != cnt) {
			Edge e = pq.poll();
			if(v[e.end])
				continue;
			
			p[e.end] = e.start;
			result += e.cost;
			pq.addAll(list[e.end]);
			v[e.end] = true;
			cnt++;
		}
		
		System.out.println(result);
	}
}
