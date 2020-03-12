import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		
		row.add(0);
		col.add(0);
		
		int T = sc.nextInt();
		
		for(int t =1; t<=T; t++) {
			int d = sc.nextInt();
			int idx = sc.nextInt();
			
			if(d==0) {
				row.add(idx);
			}
			if(d==1) {
				col.add(idx);
			}
		}
		row.add(M);		// 4	
		col.add(N);		// 3
		Collections.sort(row);
		Collections.sort(col);
		
		int max = 0;
		for(int i =0; i < col.size()-1; i++) {
			int x = col.get(i+1) - col.get(i);
			for(int j =0; j < row.size()-1; j++) {
				int y = row.get(j+1)- row.get(j);

				int sample = x*y;
				if(max < sample)
					max = sample;
				
			}
		}
		
		System.out.println(max);
    }
}