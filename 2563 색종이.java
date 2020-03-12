import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr = new int[100][100];
		
		for(int t = 1; t <= T; t++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					arr[i][j] = 1;
				}
			}
			
		}
		int count =0;
		
		for(int i =0; i < 100; i++) {
			for(int j =0; j < 100; j ++) {
				if(arr[i][j] ==0)
					continue;
				count++;
			}
		}
		System.out.println(count);
		
    }
}