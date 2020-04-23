import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] val = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i <N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =0; i < N; i++) {
			arr[i] = 1;
			for(int j =0; j < N; j++) {
				if(val[j] < val[i] && arr[i] < arr[j]+1) {
					arr[i] = arr[j]+1;
				}
			}
		}
		int max = 0;
		for(int i =0; i < N; i++) {
			max = Math.max(arr[i], max);
		}
		
		System.out.println(max);
	}
}
