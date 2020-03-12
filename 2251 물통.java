import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A,B,C;
	static boolean[][][] ABC;
	static ArrayList<Integer> list = new ArrayList<>();
	static Queue<Water> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ABC = new boolean[A+1][B+1][C+1];
		
		q.add(new Water(0, 0, C));
		
		bfs();
		
		
		Collections.sort(list);
		for(int i =0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		
	}
	
	static void bfs() {
		Water w;
		while(!q.isEmpty()) {
			w = q.poll();
			
			if(ABC[w.a][w.b][w.c])
				continue;
			
			ABC[w.a][w.b][w.c]= true; 
			
			if(w.a == 0)
				list.add(w.c);
			
			if(w.a + w.c > A)
				q.add(new Water(A, w.b, w.a+w.c - A));
			else
				q.add(new Water(w.a+w.c, w.b, 0));
			
			if(w.b + w.c > B)
				q.add(new Water(w.a, B, w.b+w.c-B));
			else
				q.add(new Water(w.a, w.b+w.c, 0));
			
			if(w.a + w.b > A)
				q.add(new Water(A, w.a+w.b-A, w.c));
			else
				q.add(new Water(w.a+w.b, 0, w.c));
			
			if(w.b + w.c > C)
				q.add(new Water(w.a, w.b+w.c-C, C));
			else
				q.add(new Water(w.a, 0, w.b+w.c));
			
			if(w.a + w.b > B)
				q.add(new Water(w.a+w.b - B, B, w.c));
			else
				q.add(new Water(0, w.a+w.b, w.c));
			
			if(w.a + w.c > C)
				q.add(new Water(w.a+w.c-C, w.b, C));
			else
				q.add(new Water(0, w.b, w.a+w.c));
			
		}
		
		
		
	}
	static class Water {
		int a;
		int b;
		int c;
		
		Water(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}