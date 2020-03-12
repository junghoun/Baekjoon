import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt = 0;
	static int zero = 0;
	static Queue<Data> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int y = Integer.parseInt(str[0]);
		int x = Integer.parseInt(str[1]);

		map = new int[x][y];
		for (int i = 0; i < x; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					q.offer(new Data(i, j));
				}
				else if(map[i][j] == 0) {
					zero++;
				}
			}
		}
		
		bfs();
		if(zero != 0)
			System.out.println(-1);
		else
			System.out.println(cnt-1);

	}

	static void bfs() {

		while (!q.isEmpty()) {
			int nx = 0, ny = 0;
			int t = q.size();
			for(int k = 0; k < t; k++) {
				Data temp = q.poll();
				for (int i = 0; i < 4; i++) {
					nx = temp.x + dx[i];
					ny = temp.y + dy[i];
					if (nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1 || map[nx][ny] != 0)
						continue;
					else{
						map[nx][ny] = 1;
						zero--;
						q.offer(new Data(nx, ny));
					}
				}
			}
			cnt++;
		}
	}

	static class Data {
		int x;
		int y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}