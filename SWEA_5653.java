import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5653 {
	static int[][] map;
	static int N, M, K;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static PriorityQueue<Data> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int max = Math.max(N, M);

			max = K * 3;

			map = new int[max][max];
			pq = new PriorityQueue<>();

			for (int i = max / 3; i < max / 3 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = max / 3; j < max / 3 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						pq.add(new Data(i, j, map[i][j], map[i][j]));
				}
			}

			
			for (int i = 0; i < K; i++) {			
				ArrayList<Data> list = new ArrayList<>();
				while(!pq.isEmpty()) {
					Data d = pq.poll();
					
					if (d.life == 0) {
						for (int j = 0; j < 4; j++) {
							int nx = d.x + dx[j];
							int ny = d.y + dy[j];
							if (map[nx][ny] != 0 || map[nx][ny] == -1)
								continue;

							map[nx][ny] = d.val;
							list.add(new Data(nx, ny, d.val, d.val));
						}
						
					}
					
					d.life--;
					if(d.life == d.val*(-1)) {
						continue;
					}
					list.add(d);
					
				}

				for (Data dd : list) {
					pq.add(dd);
				}

			}

			sb.append("#" + t + " " + pq.size() +"\n");
		}
		System.out.println(sb);
	}

	static class Data implements Comparable<Data> {
		int x, y;
		int val;
		int life;

		Data(int x, int y, int val, int life) {
			this.x = x;
			this.y = y;
			this.val = val;
			this.life = life;
		}

		@Override
		public int compareTo(Data o) {

			if (this.life != o.life)
				return Integer.compare(this.life, o.life);
			else
				return Integer.compare(o.val, this.val);
		}
	}
}
