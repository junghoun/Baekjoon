import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] v;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		v = new boolean[N + 1][M + 1];

		char[] s;

		for (int i = 1; i <= N; i++) {
			s = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s[j - 1] - '0';
			}
		}

		int min = Integer.MAX_VALUE;
		PriorityQueue<Data> q = new PriorityQueue<>();

		q.add(new Data(1, 1, 0));
		v[1][1] = true;
		while (!q.isEmpty()) {

			Data d = q.poll();

			if (d.x == N && d.y == M) {
				if (min > d.cnt)
					min = d.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if (nx < 1 || ny < 1 || nx > N || ny > M || v[nx][ny])
					continue;
				v[nx][ny] = true;
				if (map[nx][ny] == 0)
					q.add(new Data(nx, ny, d.cnt));
				else
					q.add(new Data(nx, ny, d.cnt + 1));

			}

		}

		System.out.println(min);

	}

	static class Data implements Comparable<Data> {
		int x;
		int y;
		int cnt;

		Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public int compareTo(Data d) {
			return cnt > d.cnt ? 1 : cnt == d.cnt ? 0 : -1;
		}
	}

}
