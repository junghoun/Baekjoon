import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1916 {
	static int N, M;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		ArrayList<Data> list[] = new ArrayList[M];
		
		for(int i =0; i < M; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())-1].add(new Data(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		v = new boolean[N];
		
		int[] d= new int[N];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[start] = 0;
		
		for(int i =0; i < N-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j =0; j < N; j++) {
				if(!v[j] && min > d[j]) {
					min = d[j];
					idx = j;
				}
			}
			
			if(idx == -1)
				break;
			v[idx] = true;
			
			for(Data next : list[idx]) {
				if(!v[next.ver]&& d[next.ver] > d[idx] + next.cost ) {
					d[next.ver]= d[idx] + next.cost; 
				}
			}
		}
		
		System.out.println(d[end]);
	}
	
	static class Data implements Comparable<Data>{
		int ver;
		int cost;
		
		Data(int ver, int cost) {
			this.ver = ver;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.cost, o.cost);
		}

		
	}
}
