import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252 {
	static int N, M;
	static ArrayList<Integer> list[];
	static int[] degree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i =1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}
		int v1, v2;
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			degree[v2]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =1; i<= N; i++) {
			if(degree[i] == 0)
				q.add(i);
		}
		
		for(int i =1; i<= N; i++) {
			int x= q.poll();
			sb.append(x + " ");
			
			for(int next : list[x]) {
				if(--degree[next] == 0)
					q.add(next);
			}
		}
		
		System.out.println(sb);
		
	}
}
