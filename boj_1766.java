import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] degree = new int[N+1];
		LinkedList<Integer>[] list = new LinkedList[N+1];
		
		for(int i =1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			degree[v2]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				pq.add(i);
		}
		
		for(int i =1; i <= N; i++) {
			int d = pq.poll();
			sb.append(d + " ");
			
			for(int next : list[d]) {
				if(--degree[next] == 0)
					pq.add(next);
			}
		}
		
		System.out.println(sb);
	}
}
