
public class Programmers_dfs1 {
	public static void main(String[] args) {
		
		number = new int[]{1, 1, 1, 1, 1};
		result = new int[number.length];
		int target = 3;
		
		System.out.println(solution(number, target));
	}
	
	static int[] number, result;
	static int answer = 0;
	static public int solution(int[] number, int target) {
		dfs(0, target);
		
		return answer;
	}
	
	static void dfs(int cnt, int target) {
		if(cnt == number.length) {
			int ans = 0;
			for(int i =0; i < cnt; i++) {
				ans += result[i];
			}
			if(ans == target) {
				answer++;
			}
			return;
		}
		
		int v = number[cnt];
		result[cnt] = v;
		dfs(cnt+1, target);
		v = -1 * number[cnt];
		result[cnt] = v;
		dfs(cnt+1, target);
	}
}
