import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution {
    static int N;
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<int[]> q;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t<= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            v = new boolean[N][N];
             
            for(int i =0; i < N; i++) {
                String s = br.readLine();
                for(int j =0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
                                     
            int ans = 0;
            for(int i =0; i < N; i++) { 
                for(int j =0; j < N; j++) {
                    if(map[i][j] != '.') continue;
                    if(count(i,j) ==0) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }
            for(int i =0; i < N; i++) {
                for(int j =0; j < N; j++) {
                    if(map[i][j] == '.') ans++;
                }
            }
             
            System.out.println("#"+t+" " + ans);
        }
    }
     
    static void bfs(int x, int y) {
        v[x][y] = true;
        q = new LinkedList<>();
        q.offer(new int[] {x, y});
         
        while(!q.isEmpty()) {
            int[] ij = q.poll();
            x = ij[0];
            y = ij[1];
             
            int mine = count(x, y);
            map[x][y] = (char)(mine+'0');
            if(map[x][y] != '0') continue;
             
            for(int i =0; i<8; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >=0 && nx < N && ny >=0 && ny < N && map[nx][ny]=='.' && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
                 
            }
        }
         
    }
     
     
     
    static int count(int x ,int y) {
        int mine = 0;
        for(int i =0; i<8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx < N && ny >=0 && ny < N && map[nx][ny]=='*' ) mine++;
             
        }
        return mine;
    }
}