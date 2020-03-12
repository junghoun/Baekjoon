import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = N;
		
		int t = (int)Math.sqrt(N);

		for(int i =2; i <= t; i++) {
			count += N/i - i + 1;
		}
		
		System.out.println(count);
    }
}