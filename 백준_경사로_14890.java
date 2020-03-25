import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_경사로_14890 {
	static int map[][];
	static int N,L, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][N];
		
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i < N; i++) { 
			if(find(i, 0, 'r')) result++;
			if(find(0, i , 'c')) result++;
		}
		
		System.out.println(result);
		
		
	}
	
	
	
	static boolean find(int x, int y, char c) {
        int[] load = new int[N];
        boolean[] v = new boolean[N];
 
        
        for (int i=0; i<N; i++) {
            load[i] = (c == 'r') ? map[x][y+i] : map[x+i][y];
        }
 
        for (int i=0; i<N-1; i++) {
           
            if (load[i] == load[i+1]) {
                continue;
            }
            
            if (Math.abs(load[i] - load[i+1]) > 1) {
                return false;
            }
 
            
            if (load[i] - 1 == load[i+1]) {
                for (int j=i+1; j<=i+L; j++) {
                    if (j >= N || load[i+1] != load[j] || v[j] == true) 
                        return false;
                    v[j] = true;
                }
            }
            else if (load[i] + 1 == load[i+1]) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || load[i] != load[j] || v[j] == true) 
                        return false;
                    v[j] = true;
                }
            }            
        }
 
        return true;
    }
	
}
