import java.util.Scanner;

public class Main {
	static int [] parent;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		parent = new int[N+1];
		
		int L = sc.nextInt();
		
		makeSet(parent);
		for(int i =1; i <= L; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			union(num1, num2);
		}
		
		int cnt = 0;
		for(int i =1; i < parent.length; i++) {
			if(findSet(i) == findSet(1))
				cnt++;
		}
		System.out.println(cnt-1);
		
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x==y)
			return;
		N--;
		parent[y] = x;
	}
	
	static int findSet(int x) {
		if(x == parent[x])
			return x;
		
		int nx = findSet(parent[x]);
		parent[x] = nx;
		return nx;
	}
	
	static void makeSet(int[] arr) {
		for(int i =1; i < arr.length; i++) {
			arr[i] = i;
		}
	}
}