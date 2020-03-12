import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] vD;
	static boolean[] vB;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		vD = new boolean[N+1];
		vB = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		dfs(arr, V, vD);
		System.out.println();
		bfs(V, arr, vB);
	}

	static void dfs(int[][] data, int idx, boolean[] v) {
		v[idx] = true;
		System.out.print(idx + " ");
		
		for(int i =1; i < data.length; i++) {
			if(v[i])
				continue;
			if(data[idx][i] == 0)
				continue;
			dfs(data, i, v);
		}
	}

	static void bfs(int start, int[][] data, boolean[] v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		
		int idx;
		while(!q.isEmpty()) {
			idx = q.poll();
			System.out.print(idx + " ");
			v[idx] = true;
			for(int i= 1; i < data.length; i ++) {
				if(v[i] == true || data[idx][i] == 0) {
					continue;
				}
				q.offer(i);
				v[i] = true;
			}
		}
	}

}