import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] list = new ArrayList[N];
		
		for(int i =0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int val1, val2, cost;
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			val1 = Integer.parseInt(st.nextToken())-1;
			val2 = Integer.parseInt(st.nextToken())-1;
			cost = Integer.parseInt(st.nextToken());
			list[val1].add(new Edge(val2, cost));
			list[val2].add(new Edge(val1, cost));
		}
		
		int[] d= new int[N];
		boolean[] v = new boolean[N];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0] = 0;
		
		for(int i =0; i < N-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j =0; j < N; j++) {
				if(!v[j] && min > d[j]) {
					min = d[j];
					idx = j;
				}
			}
				if(idx == Integer.MAX_VALUE)
					break;
				v[idx] = true;
				for(Edge next : list[idx]) {
					if(!v[next.ver] && d[next.ver] > next.cost) {
						d[next.ver]= next.cost; 
					}
				}
			v[idx] = true;
		}
		
		int result = 0;
		for(int i =0; i < N; i++) {
			result += d[i];
		}
		
		System.out.println(result);
		
	}
	
	static class Edge {
		int ver;
		int cost;
		
		Edge(int ver, int cost) {
			this.ver = ver;
			this.cost = cost;
		}
	}
}
