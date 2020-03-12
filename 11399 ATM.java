import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = 0;
		int value = 0;
		
		int[] arr = new int[N];
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i =0; i < N; i++) {
			value += arr[i];
			result += value;
		}
		
		System.out.println(result);
		
	}
}
