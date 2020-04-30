import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1963 {
	static boolean[] nPrime = new boolean[10000];
	static boolean[] v;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 1000; i < 10000; i++) {
            for (int j = 2; j < i/2; j++) {
                if(i % j == 0) 
                    nPrime[i] = true;
            }
        }
		
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			v = new boolean[10000];
			
			boolean flag = false;
			int min = 0;
			q = new LinkedList<>();
			
			v[a] = true;
			q.add(a);
			
			
	loop:	while(!q.isEmpty()) {
				int size = q.size();
				
				for(int s = 0; s < size; s++) {
					int d = q.poll();
					
					if(d == b) {
						flag = true;
						break loop;
					}
					
					int number[] = {d/1000, (d%1000)/100, (d%100)/10, d%10};
					
					for(int i =0; i < 4; i++) {
						for(int j = 0; j < 10; j++) {
							if(i==0 && j ==0 ) continue;
							
							int tmp = number[i];
							number[i] = j;
							int num = number[0]*1000 + number[1] *100 + number[2] *10 + number[3];
							number[i] = tmp;
							if(v[num] || nPrime[num])
								continue;
							v[num] = true;
							q.add(num);
						}
					}
				}
				min++;
			}
			System.out.println(flag ? min : "Impossible");
		}
	}
	
	
}
