import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[102][102];
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			
			for(int i =x+1; i < x+11; i++) {
				for(int j = y+1; j < y+11; j++) {
					arr[i][j] = 1;
				}
			}
			
		}
		
		
		
		int result = 0;
		
		for(int i = 1; i < 102; i++) {
			for(int j =1; j < 102; j++) {
				if(arr[i][j] == 1) {
					if(arr[i-1][j] == 0) {
						result++;
					}
					
					if(arr[i+1][j] == 0) {
						result++;
					}
					if(arr[i][j-1] == 0) {
						result++;
					}
					
					if(arr[i][j+1] == 0) {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}
}