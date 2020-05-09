import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5719 {
	static int N, M, S, D;
	static int[][] map;
	static ArrayList<Integer> list[];
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0)
				break;
			
			map = new int[N][N];
			list = new ArrayList[N];
			for(int i =0 ; i <N; i++) {
				Arrays.fill(map[i], -1);
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			for(int i =0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			solve();
			delete();
			Arrays.fill(dist, Integer.MAX_VALUE);
			System.out.println(solve());
		
		}
	}
	
	static int solve() {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		pq.add(new Data(S, 0));
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			Data d = pq.poll();
			
			for(int i =0; i < N; i++) {
				if(map[d.v][i] != -1 && dist[i] >= d.cost + map[d.v][i]) {
					dist[i] = d.cost + map[d.v][i];
					pq.offer(new Data(i, d.cost + map[d.v][i]));
					list[i].add(d.v);
				}
			}
		}
		
		
		
		return (dist[D] == Integer.MAX_VALUE ? -1 : dist[D]);
	}
	
	static void delete() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(D);
		
		while(!q.isEmpty()) {
			
			int d = q.poll();
			for(int temp : list[d]) {
				if(map[temp][d] != -1 && dist[d] == map[temp][d] + dist[temp]) {
					q.offer(temp);
					map[temp][d] = -1;	
				}
			}
			
			
			
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
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
}
