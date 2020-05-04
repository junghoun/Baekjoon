import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 400, 100, 10

public class 알골11 {
	public static void main(String[] args) throws IOException {
		//입력 받을 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 수 입력받기
		int T = Integer.parseInt(br.readLine());
		
		// 테스크 케이스 수 만큼 돌면서
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			// 시급과 시간 입력ㅂ다기
			int wage = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// 400, 100, 10센트 저장할 배열 선언
			int[] val = new int[3];
			// 일당 계산
			int result = wage*time;
			
			// 400, 100, 10이 모두 최소공배수 관계이므로 큰거부터 나눠주면 됨
			// 먼저 일당이 400원보다 클때 계속해서 나눠주기
			while(result >= 400) {
				val[0]++;
				result-= 400;
			}
			// 400으로 나눈 후 100으로 나눠주기
			while(result >= 100) {
				val[1]++;
				result-=100;
			}
			// 나머지 금액을 10으로 나눠주기
			while(result >= 10) {
				val[2]++;
				result-=10;
			}
			
			// 만약 다 나눠지지 않았다면 거슬러 줄 수없다는 뜻이므로 -1 출력
			if(result != 0) {
				System.out.println("#" + t + " " + -1);
			}
			// 아니라면 다 나눠진것이므로 배열에 넣어놓은 것 차례대로 출력
			else {
				System.out.print("#" + t + " ");
				for(int v : val) {
					System.out.print(v + " ");
				}
				System.out.println();
			}
			
			
		}
	}
}
