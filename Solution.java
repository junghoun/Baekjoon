import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 정렬 - 우선순위 중복을 제거
 * 
 * 선택정렬 O[N^2] 시간이 터짐 API 정렬 O[NlogN] : 3100ms, 중복을 직접 제거 중복제거를 TreeSet
 * O[NlongN] : 2,900ms TreeSet, 입출력 최적화:
 * 
 * 아이디어 : 글자 개수에 해당하는 배열에 글자길이가 동일한 이름들을 TreeSet으로 사전순 정렬해보자
 * 
 *  글자 개수가 작은 TreeSet 부터 출력하면 됨
 * 	글자의 개수가 골고루 포진되어 있을 때 시간을 많이 줄일 수 있다.
 */

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 이름의 개수 1~20,000

			TreeSet<String>[] tsrr = new TreeSet[51];
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i] = new TreeSet<String>(); // 배열 각 칸에 생성해서 넣기
			}

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}

			sb.append("#").append(t).append("\n");
			for (int i = 1; i < tsrr.length; i++) {
				for (String string : tsrr[i]) {
					sb.append(string + "\n");
				}
			}


		}
		System.out.println(sb);
	}

}
