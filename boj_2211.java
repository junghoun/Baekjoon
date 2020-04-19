import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Data> list[] = new ArrayList[N+1];
		for(int i =0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int s, e, c;
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list[s].add(new Data(e, c));
			list[e].add(new Data(s, c));
		}
		
		int[] d = new int[N+1];
		int[] node = new int[N+1];
		boolean[] v = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[1] = 0;
		node[1] = 1;
		
		for(int i =1; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=1; j < N+1; j++) {
				if(!v[j] && min > d[j]) {
					min = d[j];
					idx = j;
				}
			}
			
			v[idx] = true;
			
			for(Data next : list[idx]) {
				if(!v[next.ver]&& d[next.ver] > d[idx] + next.cost) {
					d[next.ver] = d[idx] + next.cost;
					node[next.ver] = idx; 
				}
			}
			
		}
		
		
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(node[i] != i ) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		for(int i =1; i < N+1; i++) {
			if(node[i] != i) {
				System.out.println(i + " " + node[i]);
			}
		}
		
	}
	
	static class Data {
		int ver;
		int cost;
		
		Data(int ver, int cost) {
			this.ver = ver;
			this.cost = cost;
		}
	}
	

}
