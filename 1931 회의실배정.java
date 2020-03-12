import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int[][] conferences = new int[N][2];
		
		for(int i =0; i < N; i++) {
			s = br.readLine().split(" ");
			conferences[i][0] = Integer.parseInt(s[0]);
			conferences[i][1] = Integer.parseInt(s[1]);
		}

		
		Arrays.sort(conferences, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		int endTime = conferences[0][1];
		int cnt = 1;
		for(int i =1; i < conferences.length; i ++) {
			if(endTime <= conferences[i][0]) {
				endTime = conferences[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
}