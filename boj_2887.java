import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2887 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		parents = new int[N];
		
		for(int i =0; i < N; i++) {
			parents[i] = i;
		}
		
		ArrayList<planet> list = new ArrayList<>();
		
		int x, y, z;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			list.add(new planet(i, x, y, z));
		}
		
		ArrayList<Data> list2 = new ArrayList<>();
		
		int xx, yy, costt;
		
		
		xsort(list);
		for(int i =0; i < list.size()-1; i++) {
			xx = list.get(i).id;
			yy = list.get(i+1).id;
			costt = list.get(i+1).x - list.get(i).x;
			list2.add(new Data(xx, yy, costt));
		}
		
		ysort(list);
		for(int i =0; i < list.size()-1; i++) {
			xx = list.get(i).id;
			yy = list.get(i+1).id;
			costt = list.get(i+1).y - list.get(i).y;
			list2.add(new Data(xx, yy, costt));
		}
		
		zsort(list);
		for(int i =0; i < list.size()-1; i++) {
			xx = list.get(i).id;
			yy = list.get(i+1).id;
			costt = list.get(i+1).z - list.get(i).z;
			list2.add(new Data(xx, yy, costt));
		}
		
		int cnt = 0;
		int result = 0;
		
		int v1, v2;
		
		Collections.sort(list2, new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				return o1.cost - o2.cost;
			}
		});
		
		
		
		for(int i =0; i < list2.size(); i++) {
			v1 = list2.get(i).start;
			v2 = list2.get(i).end;
			
			if(findSet(v1) == findSet(v2)) continue;
			
			union(v1, v2);
			cnt++;
			result += list2.get(i).cost;
			if(cnt == N-1)
				break;
			
		}
		
		System.out.println(result);
		
	}
	
	static void xsort(ArrayList<planet> list) {
		Collections.sort(list, new Comparator<planet>() {

			@Override
			public int compare(planet o1, planet o2) {
				return o1.x - o2.x;
			}
		});
	}
	
	static void ysort(ArrayList<planet> list) {
		Collections.sort(list, new Comparator<planet>() {

			@Override
			public int compare(planet o1, planet o2) {
				return o1.y - o2.y;
			}
		});
	}
	
	static void zsort(ArrayList<planet> list) {
		Collections.sort(list, new Comparator<planet>() {

			@Override
			public int compare(planet o1, planet o2) {
				return o1.z - o2.z;
			}
		});
	}
	
	static class planet {
		int id;
		int x, y, z;
		
		planet(int id, int x, int y, int z) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Data implements Comparator<Data>{
		int start;
		int end;
		int cost;
		
		Data(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compare(Data o1, Data o2) {
			return (int)(o1.cost - o2.cost);
		}

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
