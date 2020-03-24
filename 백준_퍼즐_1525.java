import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_퍼즐_1525 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = 0;
		int val = 0;
		
		for(int i =0; i< 3; i++)  {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < 3; j++) {
				val = Integer.parseInt(st.nextToken());
				if(val == 0) {
					val = 9;
				}
				
				result *=10;
				result += val;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> m = new HashMap<>();
		
		q.add(result);
		m.put(result, 0);
		
		while(!q.isEmpty()) {
			val = q.poll();
			String s = String.valueOf(val);
			int nine = s.indexOf("9");
			int x = nine/3;
			int y = nine%3;
			
			for(int i =0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 3 || ny >=3)
					continue;
				
				StringBuilder sb = new StringBuilder(s);
				int find = nx*3+ny;
				char move = s.charAt(find);
				sb.setCharAt(nine, move);
				sb.setCharAt(find, '9');
				result = Integer.parseInt(sb.toString());
				
								
				if(!m.containsKey(result)) {
					m.put(result, m.get(val)+1);
					q.add(result);
				}
				
			}
		}
		
		if(m.containsKey(123456789)) {
			System.out.println(m.get(123456789));
		}else {
			System.out.println(-1);
		}
		
		}
}
