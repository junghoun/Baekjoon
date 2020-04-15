import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Data> list[] = new ArrayList[N];
		
		for(int i =0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[v1].add(new Data(v2, cost));
			list[v2].add(new Data(v1, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int[] d = new int[N];
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
			
			if(idx == -1)
				break;
			
			v[idx] = true;
			for(Data next : list[idx]) {
				if(!v[next.ver] && d[next.ver] > next.cost) {
					d[next.ver] = next.cost; 
				}
			}
		
		}
		
		System.out.println(Arrays.toString(d));
		
		int result = 0;
		for(int i =0; i < N; i++) {
			result += d[i];
		}
		System.out.println(result);
		
	}
	
	static class Data {
		int ver;
		int cost;
		
		Data(int ver, int cost){
			this.ver = ver;
			this.cost = cost;
		}
	}
}
