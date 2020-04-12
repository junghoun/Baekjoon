public class Programmers_dfs2 {
	public static void main(String[] args) {
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(3, computers1));
		System.out.println(solution(3, computers2));
	}

	static int cnt;
	static int[] parents;

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		cnt = 0;
		parents = new int[n];
		makeSet();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					union(i, j);
				}
			}
		}
		answer = n - cnt;
		return answer;

	}

	public static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x == y)
			return;
		cnt++;
		parents[y] = x;
	}

	public static void makeSet() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = findSet(parents[x]);
	}



}