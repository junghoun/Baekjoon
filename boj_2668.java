import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_2668 {
	static int[] map;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N+1];
		
		for(int i =1; i < N+1; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i =1; i < N+1; i++) {
			v = new boolean[N+1];
			if(!list.contains(i) && dfs(i, i)) {
				
				int val = map[i];
				while(i != val) {
					list.add(val);
					val = map[val];
				}
				list.add(i);
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	static boolean dfs(int x, int start) {
		if(v[x]) return false;
		
		v[x] = true;
		
		if(map[x] == start) {
			return true;
		}else {
			return dfs(map[x], start);
		}
	}
}
