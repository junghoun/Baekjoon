import java.util.Scanner;

/**
 	정렬 - 우선순위
 	중복을 제거
 	
 	선택정렬 O[N^2] 시간 터짐
 */

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int N = sc.nextInt();		// 이름의 개수 1~20,000
			
			
			String[] name = new String[N];
			for(int i =0; i < N; i++) {
				name[i] = sc.next();
			}
			
			//선택정렬 - 우선순위
//			0~끝 : name[0] <-> name[minIndex]
//			1~끝 : name[1] <-> name[minIndex]
			
//			끝~끝 : name[끝] <-> name[minIndex]
			for(int i =0; i < name.length-1; i++) {	//범위의 시작값
				int minIndex = i;	//최소값의 방번호
				for(int j = i; j < name.length; j++) {	//범위 i ~ 끝
					if(compare(name[minIndex], name[j]) > 0) {		// 최소값이라면, 앞쪽에 배치해야 된다면
						minIndex = j;
					}
				}
				// swap name[i] <-> name[minIndex]
				String temp = name[i];
				name[i] = name[minIndex];
				name[minIndex] = temp;
			}
			System.out.println("#"+t);
			String temp = null;
			for(int i =0; i < name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		} 
	}
/*
 	바꿔야된다면, (next 앞으로 가야한다면) 양수를 리턴
 */	
	private static int compare(String pre, String next) {
		if(pre.length() != next.length()) {	//글자의 길이 짧은 순서
			return pre.length() - next.length();
		} else {	//길이가 같으면, 사전순 정렬
			return pre.compareTo(next);
		}
	}
}
