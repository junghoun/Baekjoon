import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int max = 0;
		int maxi = 0;

		for (int i = 1; i <= N; i++) {
			int count = 2;
			int next = N - i;
			int idx = i;
			if (next < 0)
				break;
			while (next >= 0) {
				count++;
				int first = next;
				next = idx - next;
				idx = first;
			}
			if (max < count) {
				max = count;
				maxi = i;
			}
		}

		System.out.println(max);
		System.out.print(N + " ");
		int temp = maxi;
		while (temp >= 0) {
			System.out.print(temp + " ");
			temp = N - maxi;
			N = maxi;
			maxi = temp;
		}
	}

}