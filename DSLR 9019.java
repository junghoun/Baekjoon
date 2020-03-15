import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[] v;
	static int[] number;
	static Stack<Character> s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			v = new char[10001];
			number = new int[10001];
			Arrays.fill(v, '.');

			bfs();
		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		s = new Stack<Character>();
		q.add(N);

back:	while (!q.isEmpty()) {
			int size = q.size();
			
			for(int t = 0; t< size; t++) {
				int num = q.poll();
				
				if(num ==M) {
					
					while(M != N) {
						s.add(v[M]);
						M = number[M];
					}
					
					while(!s.isEmpty()) {
						System.out.print(s.pop());
					}
					System.out.println();
					break back;
				}
				
				int temp = (num *2)%10000;
				
				if(v[temp] == '.') {
					q.add(temp);
					number[temp] = num;
					v[temp] = 'D';
				}
				
				temp = num-1;
				if(temp ==-1)
					temp = 9999;
				if(v[temp] == '.') {
					q.add(temp);
					number[temp] = num;
					v[temp] = 'S';
				}
				
				temp = (num%1000)*10 + num/1000;
				if(v[temp] == '.') {
					q.add(temp);
					number[temp] = num;
					v[temp] = 'L';
				}
				
				temp = (num%10)*1000 + num/10;
				if(v[temp] == '.') {
					q.add(temp);
					number[temp] = num;
					v[temp] = 'R';
				}
				
			}

		}

	}
	
	static int left(int num) {
		int temp = 0;
		
		
		return temp;
	}
}
