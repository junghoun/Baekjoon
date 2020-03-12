import java.util.Scanner;

public class Main {
	static int[] arr;
	static int N,M;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		v = new boolean[N];
		dfs(0);
	}
	
	static void dfs(int start) {
		if(start == arr.length) {
			for(int i =0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =1; i < N+1; i++) {
			if(v[i-1] ==true)
				continue;
			arr[start] = i;
			v[i-1] = true;
			dfs(start+1);
			v[i-1] = false;
		}
		
	}
}
