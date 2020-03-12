import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int count = 0;
		
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = N-1; i >0; i--) {
			if(arr[i] > arr[i-1])
				continue;
			
			count += arr[i-1] - (arr[i]-1);;
			arr[i-1] = arr[i]-1;
		}
		
		System.out.println(count);
    }
}