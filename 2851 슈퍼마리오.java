import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] arr = new int[10];
		int idx = 9;
		
		for(int i =0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i =0; i < 10; i++) {
			sum += arr[i];
			if(sum >=100) {
				idx = i;
				break;
			}
		}
		
		int small = sum - arr[idx];
		int big = sum;
		
		int result = (100-small >= big-100) ? big : small;
		
		System.out.println(result);
		
		
//		System.out.println(result);
	}
}