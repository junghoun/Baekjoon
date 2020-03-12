import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char [][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] v;
	static int N, P =0, RGM = 0;
	static Queue<Data>q = new LinkedList<>();
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   N = Integer.parseInt(br.readLine());
	   
	   map = new char[N][N];
	   
	   for(int i =0; i < N; i++) {
		   char[] s = br.readLine().toCharArray();
		   for(int j =0; j < N; j++) {
			   map[i][j] = s[j]; 
		   }
	   }
	   
	   
	   v = new boolean[N][N];
	   for(int i =0; i < N; i++) {
		   for(int j =0; j < N; j++) {
			   if(!v[i][j]) {
				   bfs(i, j);
				   P++;
			   }
		   }
	   }
	   
	   
	   v = new boolean[N][N];
	   for(int i =0; i < N; i++) {
		   for(int j =0; j < N; j++) {
			   if(map[i][j]=='R')
				   map[i][j] = 'G';
		   }
	   }	   

	   for(int i =0; i < N; i++) {
		   for(int j =0; j < N; j++) {
			   if(!v[i][j]) {
				   bfs(i, j);
				   RGM++;
			   }
		   }
	   }
	   System.out.println(P + " " + RGM);
	   
   }
   
   static void bfs(int i, int j) {
	   char c = map[i][j];
	   v[i][j] = true;
	   q.add(new Data(i, j));
	   Data d;
	   int nx, ny;
	   
	   while(!q.isEmpty()) {
		   d = q.poll(); 
		   for(int k =0; k < 4; k++) {
			   nx = d.x + dx[k];
			   ny = d.y + dy[k];
			   if(nx < 0 || ny <0 || nx > N-1 || ny >N-1 || v[nx][ny] || map[nx][ny] != c)
				   continue;
			   q.add(new Data(nx, ny));
			   v[nx][ny] = true;
		   }
	   }
   }

   
   static class Data{
	   int x;
	   int y;
	   Data(int x, int y){
		   this.x = x;
		   this.y = y;
	   }
   }
}