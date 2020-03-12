import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] v;
	static ArrayList<Integer>[] map = (ArrayList<Integer>[]) new ArrayList[10001];
	static int[] result = new int[10001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());		
		
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<Integer>();
		}

		int start, end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start].add(end);
		}
		
		for(int i = 1; i < N+1; i++) {
			v = new boolean[10001];
			dfs(i);
		}
		
		int max = 0;
		
		for(int i = 1; i < N+1; i++) {
			if(max < result[i])
				max = result[i];
		}
		
		for(int i = 1; i < N+1; i++) {
			if(max == result[i])
				System.out.print(i + " ");
		}
		
	}
	
	static void dfs(int temp) {
		v[temp] = true;
		
		for(int i : map[temp]) {
			if(!v[i]) {
				result[i]++;
				dfs(i);
			}
		}
	}

}