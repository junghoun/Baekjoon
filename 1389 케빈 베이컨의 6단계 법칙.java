import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int N, M;
	static boolean[] v;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int num1 = Integer.parseInt(s[0]);
			int num2 = Integer.parseInt(s[1]);
			map[num1][num2] = 1;
			map[num2][num1] = 1;
		}

		int idx = 0;
		for (int i = 1; i < N + 1; i++) {
			int temp = bfs(i);
			if(min > temp) {
				min = temp;
				idx = i;
			}
		}
		System.out.println(idx);
	}

	static int bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		v = new boolean[N + 1];
		q.add(x);
		int cnt = 0, temp = 0;
		v[x] = true;

		while (!q.isEmpty()) {
			int T = q.size();
			cnt++;
			for (int t = 0; t < T; t++) {
				int i = q.poll();
				for(int j = 1; j < N+1; j++) { 
					if(map[i][j] == 1 && !v[j]) {
						v[j] = true;
						q.add(j);
						temp += cnt;
					}
						
				}

			}
		}
		return temp;
	}

}