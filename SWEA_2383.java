import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2383 {
	static int ans, N;
	static int[][] map;
	static Door[] door;
	static List<Person> list = new ArrayList<>();
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			ans = Integer.MAX_VALUE;
			list.clear();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			door = new Door[2];
			for(int i =0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) list.add(new Person(i, j, 0, 0, 0, 0));
					if(map[i][j] > 1) {
						if(door[0]==null) door[0] = new Door(i, j, map[i][j]);
						else door[1] = new Door(i, j, map[i][j]);
					}
				}
			}
			v = new boolean[list.size()];
			dfs(0);
			
			sb.append("#" + t + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(idx == list.size()) {
			solve();
			return;
		}
		v[idx] = true;
		dfs(idx+1);
		v[idx] = false;
		dfs(idx+1);
	}
	
	static void solve() {
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.time > o2.time) return 1;
				else if(o1.time == o2.time) {
					if(o1.dist > o2.dist) return 1;
					else if(o1.dist == o2.dist) return 0;
					else return -1;
				}else
					return -1;
			}
		});
		
		// x, y, gate, wait, dist, time
		int dist = 0;
		for(int i =0; i < list.size(); i++) {
			Person p = list.get(i);
			dist = 0;
			if(v[i]) {
				dist = Math.abs(p.x-door[0].x) + Math.abs(p.y - door[0].y);
				pq.add(new Person(p.x, p.y, 0, 0, dist, 0));
			}else {
				dist = Math.abs(p.x-door[1].x) + Math.abs(p.y - door[1].y);
				pq.add(new Person(p.x, p.y, 1, 0, dist, 0));
			}
		}
		int time = 0;
		int[] stairs = new int[2];
		while(!pq.isEmpty()) {
			Person p = pq.poll();
			time = p.time;
			if(p.dist >= time) {
				pq.add(new Person(p.x, p.y, p.gate, p.wait, p.dist, p.time+1));
				continue;
			}
			
			if(p.wait != 0) {
				if(p.wait == door[p.gate].cnt) {
					stairs[p.gate]--;
					continue;
				}
				pq.add(new Person(p.x, p.y, p.gate, p.wait+1, p.dist, p.time+1));
				continue;
			}
			
			if(stairs[p.gate]==3) {
				pq.add(new Person(p.x, p.y, p.gate, p.wait, p.dist, p.time+1));
			}else {
				stairs[p.gate]++;
				pq.add(new Person(p.x, p.y, p.gate, p.wait+1, p.dist, p.time+1));
			}
		}
		ans = Math.min(ans,  time);
		
	}
	
	static class Door {
		int x, y, cnt;
		
		public Door(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	static class Person {
		int x, y, gate, wait, dist, time;
		
		public Person(int x, int y, int gate, int wait, int dist, int time) {
			this.x = x;
			this.y = y;
			this.gate = gate;
			this.wait = wait;
			this.dist = dist;
			this.time = time;
		}
	}
}
