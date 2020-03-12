import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int T = sc.nextInt();
		
		for(int t =1; t<= T; t++) {
			int s = sc.nextInt();
			switch(s) {
			case 1:
				int dm = sc.nextInt();
				for(int i = dm-1; i < N; i += dm) {
					arr[i] = (arr[i] == 1) ? 0 : 1;
				}
				break;
			case 2:
				int dw = sc.nextInt();
				int start = dw-1;
				arr[start] = (arr[start] == 1) ? 0 : 1;
				int back = start;
				int go = start;
				while(true) {
					back = back-1;
					go = go+1;
					if(back < 0 || go > N-1 || arr[back] != arr[go]) {
						break;						
					}
					else {
						arr[back] = (arr[back] == 1) ? 0 : 1;
						arr[go] = (arr[go] == 1) ? 0 : 1;
					}
				}
			}
		}
		
		for(int i =1; i < N+1; i++) {
			System.out.print(arr[i-1] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
	}
}