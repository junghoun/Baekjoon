import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10775 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		parents = new int[G+1];
		
		for(int i =1; i <=G; i++) {
			parents[i] = i;
		}
		
		for(int i =0; i < P; i++) {
			int val = Integer.parseInt(br.readLine());
			if(findSet(val) != 0) {
				union(findSet(val), findSet(val)-1);
				cnt++;
			}else {
				break;
			}
		}
		
		
		System.out.println(cnt);
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		parents[x] =y;
	}
	
	static int findSet(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = findSet(parents[x]);
	}
}
