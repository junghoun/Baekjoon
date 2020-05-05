import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_10282 {
	static int N, D, C;
	static ArrayList<Data> list[];
	static int[] d;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int a,b,s;
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N];
			for(int i =0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken())-1;
				b = Integer.parseInt(st.nextToken())-1;
				s = Integer.parseInt(st.nextToken());
				list[b].add(new Data(a, s));
			}
			
			v = new boolean[N];
			v[C-1] = true;
			PriorityQueue<Data> pq = new PriorityQueue<>();
			for(Data d : list[C-1])
				pq.add(d);
			int cost = 0;
			int cnt = 1;
			while(!pq.isEmpty()) {
				Data d= pq.poll();
				
				if(v[d.v]) continue;
				v[d.v] = true;
				
				cnt++;
				cost = d.cost;
				
				for(Data dd : list[d.v]) {
					pq.add(new Data(dd.v, dd.cost + d.cost));
				}
			}
			
			System.out.println(cnt + " " + cost);
		}
	}
	
	static class Data implements Comparable<Data>{
		int v;
		int cost;
		
		Data(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			
			return Integer.compare(this.cost, o.cost);
		}
	}
}
