import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {
	static int[][] map, v;
	static int[] dx = {-1, 0, 1 ,0};
	static int[] dy = {0, 1, 0, -1};
	static int x, y, result, eat, size = 2;
	static int cur_x, cur_y, min_dir, min_x, min_y;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		v = new int[n+1][n+1];
		
		for(int i =1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			min_dir = 401;
			min_x = 21;
			min_y = 21;
			for(int i =1; i<= n; i++) {
				Arrays.fill(v[i], -1);
			}
			
			dfs(x, y);
			if(min_x != 21 && min_y != 21) {
				eat++;
				result += v[min_x][min_y];
				
				if(eat == size) {
					size++;
					eat = 0;
				}
				map[min_x][min_y] = 0;
				x = min_x;
				y = min_y;
			}else{
				break;
			}
			
		}
		
		System.out.println(result);
		
	}
	
	static void dfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x, y));
		v[x][y] = 0;
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			
			for(int i =0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx < 1 || ny < 1 || nx > map.length-1 || ny > map[0].length-1 || v[nx][ny] != -1 || size < map[nx][ny])
					continue;
				v[nx][ny] = v[d.x][d.y] + 1;
				
				if(map[nx][ny] != 0 && size > map[nx][ny]) {
					if(min_dir > v[nx][ny]) {
						min_x = nx;
						min_y = ny;
						min_dir = v[nx][ny];
					}
					else if(min_dir == v[nx][ny]) {
						if(nx < min_x) {
							min_x = nx;
							min_y = ny;
						}
						else if(min_x == nx) {
							if(min_y > ny) {
								min_y = ny;
							}
						}
					}
				}
				q.add(new Data(nx, ny));
				
			}
		}
	}
	
	static class Data {
		int x;
		int y;
		Data (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
