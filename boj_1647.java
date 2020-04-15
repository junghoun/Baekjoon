import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1647 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Data> list = new ArrayList<>();
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Data(v1, v2, cost));
			}
		
		parents=  new int[N];
		boolean[] v = new boolean[N];
		
		for(int i =0; i < N; i++) {
			parents[i] = i;
		}
		
		Collections.sort(list);
		
		int cnt = 0;
		int result = 0;
		int max = 0;
		
		
		for(int i =0; i < M; i++) {
			int v1 = findSet(list.get(i).start);
			int v2 = findSet(list.get(i).end);
			
			if(v1 == v2)
				continue;
			
			union(v1, v2);
			cnt++;
			max = Math.max(max, list.get(i).cost);
			result += list.get(i).cost;
			System.out.println(list.get(i).cost);
			if(cnt == N-1)
				break;
		}

		System.out.println(result-max);
		
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x==y) return;
		
		parents[y] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x]) return x;
		
		
		return parents[x] = findSet(parents[x]);
		
 	}
	
	static class Data implements Comparable<Data>{
		int start;
		int end;
		int cost;
		
		Data(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
