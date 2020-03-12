import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] map, temp, test;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, max = 0;
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   
	   map = new int[N][M];
	   temp = new int[N][M];
	   
	   for(int i =0; i < N; i++) {
		   st = new StringTokenizer(br.readLine());
		   for(int j = 0; j < M; j++) {
			   temp[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
		   }
	   }
	   
	   for(int i =0 ; i < N; i ++) {
		   for(int j =0; j < M; j++) {
			   if(temp[i][j] == 0) {
				   temp[i][j] = 1;
				   dfs(i, j, 1);
				   temp[i][j] = 0;
			   }
		   }
	   }
	   
	   System.out.println(max);
   }

   static void dfs(int x, int y, int cnt) {
	   if(cnt == 3) {
		   test = new int[N][M];
		   for(int i = 0; i < N; i++) {
			   for(int j =0; j < M; j++) {
				   test[i][j] = temp[i][j];
			   }
		   }
		   
		   for(int i =0; i < N; i++) {
			   for(int j =0; j < M; j++) {
				   if(test[i][j]==2)
					   bfs(i, j);
			   }
		   }
		   int value = 0;
		   for(int i =0; i < N; i++) {
			   for(int j =0; j < M; j++) { 
				   if(test[i][j] == 0)
					   value++;
			   }
		   }
		   if(value > max)
			   max = value;
	   }
	   else {
	   for(int i =0; i < N; i++) {
		   for(int j =0; j < M; j++) {
			   if(temp[i][j] == 0) {
				   temp[i][j] = 1;
				   dfs(i, j, cnt+1);
			   }
		   }
	   	}
	   }
	   temp[x][y] = 0;
	   cnt--;
   }
   
   static void bfs(int x, int y) {
	   int nx, ny;
	   for(int i =0; i < 4; i++) {
		   nx = x + dx[i];
		   ny = y + dy[i];
		   if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || test[nx][ny] !=0)
			   continue;
		   test[nx][ny] = 3;
		   bfs(nx, ny);
	   }
   }

}