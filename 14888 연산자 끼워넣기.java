import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
	static int[] arr;
	static int[] oper = new int[4];
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		
		arr = new int[N];
		
		s = br.readLine().split(" ");
		for(int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		s = br.readLine().split(" ");
		for(int i =0; i < 4; i++) {
			oper[i] = Integer.parseInt(s[i]);
		}
		
		dfs(0, arr[0]);
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	
	static void dfs(int x, int sum) {
		if(x == N-1) {
			list.add(sum);
		}
		
		for(int i =0; i < 4; i++) {
			if(oper[i] == 0)
				continue;
			
			oper[i]--;
			
			switch(i) {
			case 0:
				dfs(x+1, sum + arr[x+1]);
				break;
			case 1:
				dfs(x+1, sum - arr[x+1]);
				break;
			case 2:
				dfs(x+1, sum * arr[x+1]);
				break;
			case 3:
				dfs(x+1, sum / arr[x+1]);
				break;
			}
			oper[i]++;
		}
		
		
	}
}