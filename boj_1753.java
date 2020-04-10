import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj_1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		
		ArrayList<Edge> list[] = new ArrayList[V];
		for(int i =0; i < V; i++ ) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Edge(v2, w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] v = new boolean[V];
		Edge[] d = new Edge[V];

		for(int i = 0; i < V; i++) {
			//원하는 출발지
			if( i == K ) {
				d[i] = new Edge(i, 0);
				v[i] = true;
			}
			else {
				d[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(d[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(edge.w == Integer.MAX_VALUE)
				break;
			for(Edge next : list[edge.v]) {
				if(!v[next.v]&& d[next.v].w > d[edge.v].w + next.w ) {
					d[next.v].w = d[edge.v].w + next.w;
					pq.remove(d[next.v]);
					pq.add (d[next.v]);
				}
			}
			v[edge.v] = true;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i <V; i++) {
			if( d[i].w == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(d[i]+"\n");
		}
		
		System.out.println(sb);
		}
	
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		
		Edge(int v, int w){
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return w + "";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
