import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15685 {
	static int x, y, d, g, cnt;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		v = new boolean[101][101];
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			draw(y, x, find(d, g));
		}
		calc(v);
		
		System.out.println(cnt);
		
	}
	
	static ArrayList<Integer> find(int d, int g) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(d);
		while(g --> 0) {
			for(int i = list.size()-1; i >=0; i--) {
				int dir = (list.get(i) + 1) %4;
				list.add(dir);
			}
		}
		return list;
	}
	
	// 0 :오  1 : 위  2 : 왼  3 : 아
	static void draw(int x, int y, ArrayList<Integer> list) {
		v[x][y] = true;
		int dir;
		for(int i =0; i < list.size(); i++) {
			dir = list.get(i);
			switch(dir) {
			case 0:
				v[x][++y] = true;
				break;
			case 1:
				v[--x][y] = true;
				break;
			case 2:
				v[x][--y] = true;
				break;
			default:
				v[++x][y] = true;
				break;
			}
		}
	}
	
	static void calc(boolean[][] v) {
		
		for(int i =0; i < 100; i++) {
			for(int j =0; j < 100; j++) {
				if(v[i][j] && v[i+1][j] && v[i][j+1] && v[i+1][j+1])
					cnt++;
			}
		}
	}
}
