import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        if (nextPermutation(arr)) {
            for (int i=0; i<N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }


	}
	
	static boolean nextPermutation(int[] a) {
		int i = a.length-1;
		
		while(i >0 && a[i-1] >= a[i]) {
			i--;
		}
		
		if(i <=0)
			return false;
		
		int j = a.length-1;
		while(a[i-1] >= a[j]) {
			j--;
		}
		
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}
}