import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16637 {
	static int N, max = Integer.MIN_VALUE;
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		arr = br.readLine().toCharArray();
		
		dfs(1, arr[0]-'0', 0, false);	
		
		System.out.println(max);
	}
	
	static void dfs(int idx, int val, int pre, boolean flag) {
		
		if(idx >= N) {
			max = Math.max(max, val);
			return;
		}
		
		dfs(idx+2, oper(val, arr[idx+1]-'0', arr[idx]), val, false);
		
		if(idx >1 && !flag) {
			dfs(idx+2, oper(pre, oper(arr[idx-1]-'0', arr[idx+1]-'0', arr[idx]), arr[idx-2]), 0, true);
		}
		
	}
	
	
	static int oper(int a, int b, char op) {
		if(op =='+') return a+b;
		else if(op == '-') return a-b;
		else return a*b;
	}
}
