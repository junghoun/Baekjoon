import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int x, y;
		for(int t =1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;	
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(one);
		
		int nx;
		while(!q.isEmpty()) {
			nx = q.poll();
			
			for(int i =1; i < map.length; i++) {
				if(map[nx][i] ==0 || arr[i] !=0)
					continue;
				arr[i] = arr[nx]+1;
				q.add(i);
			}
		}
		
		if(arr[two] ==0)
			System.out.println(-1);
		else
			System.out.println(arr[two]);
		
	}
	
}