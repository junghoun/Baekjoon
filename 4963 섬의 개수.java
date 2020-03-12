import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int count =2;
	static int[][] map;
	static Queue<land> q = new LinkedList<>();
	static int nx, ny, w, h;
	static int i,j,k;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			if(w == 0)
				break;
			h = sc.nextInt();
			
			map = new int[h][w];
			
			for(i =0; i < h; i++) {
				for(int j =0; j <w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(i =0; i < h; i++) {
				for(j =0; j < w; j++) {

					if(map[i][j] == 1) {
						q.offer(new land(i, j));
						land l;
						map[i][j]= count;
						
						while(!q.isEmpty()) {
							l = q.poll(); 
							
							for(k =0; k < 8; k++) {
								
								nx = l.x + dx[k];
								ny = l.y + dy[k];
								if(nx <0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] != 1 )
									continue;
								else {
									map[nx][ny]= count;
									q.offer(new land(nx, ny));
								}
							}
							
							
						}
						
					
						count++;
					}
				}
			}
			
			
			
			System.out.println(count-2);
			count = 2;
			
			
	
		}
		sc.close();
	}
	
	
	static class land {
		int x;
		int y;
		
		land(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}