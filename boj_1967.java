import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_1967 {
	static int N, s, e, len;
	static LinkedList<Data> list[];
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new LinkedList[N+1];
		v = new boolean[N+1];
		
		for(int i =0; i < N+1; i++) {
			list[i] = new LinkedList<>();
		}
		
		int start, end, val;
		for(int i =0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			list[start].add(new Data(end, val));
			list[end].add(new Data(start, val));
		}
		v[1] = true;
		dfs(1, 0);
		
		len = 0;
		
		v = new boolean[N+1];
		v[s] = true;
		dfs(s, 0);
		
		System.out.println(len);
	}
	
	static void dfs(int start, int sum) {
		if(len < sum) {
			len = sum;
			s = start;
		}
		
		for(Data d : list[start]) {
			if(!v[d.v]){
				v[d.v]= true;
				dfs(d.v, sum + d.val);
			}
		}
		
	}
	
	static class Data {
		int v;
		int val;
		
		Data(int v, int val) {
			this.v = v;
			this.val = val;
		}
		
	}
}
