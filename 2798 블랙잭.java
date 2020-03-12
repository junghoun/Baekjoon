import java.util.Scanner;

public class Main {
	static int[] arr;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
	
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(0, 0, 0));
		
	}
	private static int solution(int sum, int idx, int cnt) {
        if(cnt == 3) {
            return sum > M ? 0 : sum;
        }
        if(idx >= N) {
            return 0;
        }
        
        int max = 0;
        for(int i = idx; i < N; i++) {
            max = Math.max(max, solution(sum+arr[i], i+1, cnt+1));
        }
        return max;
    }
}