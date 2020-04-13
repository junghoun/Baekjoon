import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15686 {
	static int N, K;
	static int[][] map, chicken, person;
	static boolean[] v;
	static int[] arr, pp;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		
		int p = 0, c = 0;
		int val = 0;
		map = new int[N][N];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				val = Integer.parseInt(st.nextToken());
				if(val == 2) {
					c++;
				}else if(val == 1) {
					p++;
				}
				map[i][j] = val;
			}
		}
		chicken = new int[c][2];
		person = new int[p][2];
		v = new boolean[c];
		int pc =0, cc = 0;
		for(int i =0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] == 1) {
					person[pc][0] = i;
					person[pc++][1] = j;
				}
				if(map[i][j] == 2) {
					chicken[cc][0] = i;
					chicken[cc++][1] = j;
					map[i][j] = 0;
				}
			}
		}
		
		dfs(0, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == K) {
			pp = new int[person.length];
			Arrays.fill(pp, Integer.MAX_VALUE);
			int sum = 0;
			for(int i =0; i < arr.length; i++) {
				for(int j =0; j < pp.length; j++) {
					pp[j] = Math.min(pp[j], Math.abs(person[j][0]-chicken[arr[i]][0]) + Math.abs(person[j][1]-chicken[arr[i]][1]));
				}
			}
			for(int i =0; i < pp.length; i++) {
				sum += pp[i];
			}
			if(min > sum)
				min = sum;
			
			return;
		}
		
		for(int i = start; i < chicken.length; i++) {
			if(v[i])
				continue;
			v[i] = true;
			arr[cnt] = i;
			dfs(i+1, cnt+1);
			v[i] = false;
			
		}
	}
}
