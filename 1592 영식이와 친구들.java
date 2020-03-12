import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N + 1];
		arr[1] = 1;
		int result = 0;

		int start = 1;
		while (true) {
			if (arr[start] % 2 == 0) {
				if (start > L)
					start -= L;
				else
					start = N - (L - start);
				arr[start]++;
			} else {
				if (start + L > N)
					start = (start + L) - N;
				else
					start = start + L;
				arr[start]++;
			}
			result++;

			if (arr[start] == M) {
				break;
			}
		}

		System.out.println(result);
	}

}