import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 	정렬 - 우선순위
 	중복을 제거
 	
 	선택정렬 O[N^2] 시간이 터짐
 	API 정렬 O[NlogN] : 3100ms, 중복을 직접 제거
 	중복제거를 TreeSet O[NlongN] : 2,900ms
 	TreeSet, 입출력 최적화:
 	
 */

public class Solution4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());		// 이름의 개수 1~20,000
			
			
			
			TreeSet<String> name = new TreeSet<String>(new Comparator<String>() {
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) {	//글자의 길이 짧은 순서
						return pre.length() - next.length();
					} else {	//길이가 같으면, 사전순 정렬
						return pre.compareTo(next);
					}
				}
				
			});
			for(int i =0; i < N; i++) {
				name.add(br.readLine());
			}
			
			
			sb.append("#").append(t).append("\n");
			for (String string : name) {
				sb.append(string + "\n");
			}
			
		}
		System.out.println(sb);
	}
	
}
