import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int N = s.length();
		
		int R=0, C =0;
		
		for(int i =1; i <=N; i++) {
			if(N%i == 0) {
				R = i;
				C = N/i;
				if(R >= C)
					break;
			}
		}	
		if(R !=C) {
			int temp = R;
			R = C;
			C = temp;
		}
		
		char[][] ch = new char[R][C];
		int count = 0;
		
		for(int i =0; i < C; i++) {
			for(int j =0; j < R; j++) {
				ch[j][i] = s.charAt(count++);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(ch[i][j]);
			}
		}
	}
}