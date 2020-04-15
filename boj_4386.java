import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class boj_4386 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		parents = new int[N];
		
		for(int i =0; i < N; i++) {
			parents[i] = i;
		}

		double[][] star = new double[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}

		double val;
		ArrayList<Star> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				val = Math.sqrt((Math.pow(star[i][0] - star[j][0], 2) + Math.pow(star[i][1] - star[j][1], 2)));
				list.add(new Star(i, j, val));
			}
		}
		
		Collections.sort(list, new Comparator<Star>() {

			@Override
			public int compare(Star o1, Star o2) {
				return (int)(o1.cost - o2.cost);
			}
		});
		
		int cnt = 0;
		double result = 0;
		
		int x, y;
		for(int i =0; i < list.size(); i++) {
			x = list.get(i).idx;
			y = list.get(i).idy;
			
			if(findSet(x) == findSet(y)) continue;
			
			cnt++;
			union(x, y);
			result += list.get(i).cost;
			
			if(cnt == N-1)
				break;
		}
		
		System.out.printf("%.2f\n", result);
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

	static class Star implements Comparable<Star> {
		int idx;
		int idy;
		double cost;

		Star(int idx, int idy, double cost) {
			this.idx = idx;
			this.idy = idy;
			this.cost = cost;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}