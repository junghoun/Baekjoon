import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12886 {
	static int[] arr;
	static int sum, result = 0;
	static boolean[][] v = new boolean[1001][1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[3];
		for(int i =0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		if(sum%3!= 0) 
			System.out.println(0);
		else {
			bfs(arr[0], arr[1]);
			System.out.println(result);
		}
	}
	
	
	static void bfs(int a, int b) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(a, b));
		v[a][b] = true;
		
		while(!q.isEmpty()) {
			Data d= q.poll();
			int x = d.one;
			int y = d.two;
			int z = sum - x - y;
			if(x==y && y == z) {
				result = 1;
				break;
			}
			
			if(x > y && y+y <= 1000 && !v[x-y][y+y]) {
				v[x-y][y+y] = true;
				q.add(new Data(x-y, y+y));
			}
			
			if(x < y && x+x <= 1000 && !v[x+x][y-x]) {
				v[x+x][y-x] = true;
				q.add(new Data(x+x, y-x));
			}
			if(x > z && z+z <= 1000 && !v[z+z][x-z]) {
				v[z+z][x-z] = true;
				q.add(new Data(z+z, x-z));
			}
			if(x < z && x + x <= 1000 && !v[x+x][z-x]) {
				v[x+x][z-x] = true;
				q.add(new Data(x+x, z-x));
			}
			
			if(y > z && z+z <= 1000 && !v[z+z][y-z]) {
				v[z+z][y-z] = true;
				q.add(new Data(z+z, y-z));
			}
			if(y < z && y + y <= 1000 && !v[y+y][z-y]) {
				v[y+y][z-y] = true;
				q.add(new Data(y+y, z-y));
			}
		}
	}
	
	static class Data {
		int one;
		int two;
		
		
		Data(int one, int two) {
			this.one = one;
			this.two = two;
		}
	}
}
