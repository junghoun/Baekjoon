import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int [][] map, v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static int result = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   String[] s = br.readLine().split(" ");
	   N = Integer.parseInt(s[0]);
	   M = Integer.parseInt(s[1]);
	   map = new int[N][M];
	   v = new int[N][M];
	   for(int i =0; i < N; i++) {
		   s = br.readLine().split("");
		   for(int j =0; j < M; j++) {
			   map[i][j] = Integer.parseInt(s[j]);
			   v[i][j] = Integer.MAX_VALUE;
		   }
	   }
	   
	   bfs();
	   
	   System.out.println((result != Integer.MAX_VALUE)? result : -1);
	   
   }
   static void bfs() {
	   Queue<Data> q = new LinkedList<>();
	   q.add(new Data(0, 0, 1, 0));
	   v[0][0] = 0;
	   Data d;
	   int nx, ny;
	   
	   while(!q.isEmpty()) {
		   d = q.poll();
		   if(d.x == N-1 && d.y == M-1) {
			   result = d.cnt;
			   break;
			} 
		   
		   for(int i =0; i < 4; i++) {
			   nx = d.x+dx[i];
			   ny = d.y+dy[i];
			   if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) {
				   continue;
			   }
			   if(v[nx][ny] <= d.drill) continue;
			   
			   if(map[nx][ny] == 0) {
				   v[nx][ny] = d.drill;
				   q.add(new Data(nx, ny, d.cnt+1, d.drill));
			   }
			   else {
				   if(d.drill == 0) {
					   v[nx][ny] = d.drill+1;
					   q.add(new Data(nx, ny, d.cnt+1, d.drill+1));
				   }
			   }
		   }
	   }
   }
   
   
   static class Data{
	   int x;
	   int y;
	   int cnt;
	   int drill;
	   
	   Data(int x, int y, int cnt, int drill){
		   this.x = x;
		   this.y = y;
		   this.cnt = cnt;
		   this.drill = drill;
	   }
   }
}