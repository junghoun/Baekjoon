import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class boj_1922_kruskal {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		makeSet();
		
		ArrayList<Data> list = new ArrayList<>();
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int val1 = Integer.parseInt(st.nextToken())-1;
			int val2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Data(val1, val2, cost));
		}
		
		Collections.sort(list, new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.cost - o2.cost;
			}
		});
		
		int cnt = 0;
		int result = 0;
		for(int i =0; i < M; i++) {
			int v1 = findSet(list.get(i).start);
			int v2 = findSet(list.get(i).end);
			if(v1 == v2)
				continue;
			union(v1, v2);
			result += list.get(i).cost;
			cnt++;
			if(cnt == N-1)
				break;
		}
		
		System.out.println(result);
		
	}
	
	static void makeSet() {
		for(int i =0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x == y) return;
		
		parents[y] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x]) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	static class Data{
		int start;
		int end;
		int cost;
		
		Data(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}
