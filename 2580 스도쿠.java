import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static int map[][];
	static int size;
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		
		String[] s;
		
		for(int i =0; i < 9; i++) {
			s = br.readLine().split(" ");
			for(int j= 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i =0; i < 9; i++) { 
			for(int j =0; j < 9; j++) {
				if(map[i][j] == 0) {
					list.add(new Node(i, j));
				}
			}
		}
		size = list.size();
		
		dfs(0, 0);
		
	}
	
	static boolean v;
	static void dfs(int idx, int cnt) {
		if(v) return;
		if(size == cnt) {
			v = true;
			for(int i =0; i < 9; i++) {
				for(int j =0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		Node node = list.get(idx);
		
		for(int i = 0; i < 10; i++) {
			if(row(node.x, node.y, i) && col(node.x, node.y, i) && box(node.x, node.y, i)) {
				map[node.x][node.y] = i;
				dfs(idx+1, cnt+1);
				if(v) return;
				map[node.x][node.y] = 0; 
			}
		}
		
	}
	
	static boolean row(int x, int y, int cnt) {
		for(int i = 0; i < 9; i++) {
			if(map[x][i] == cnt)
				return false;
		}
		return true;
	}
	
	static boolean col(int x, int y, int cnt) {
		for(int i =0; i < 9; i ++) {
			if(map[i][y] == cnt)
				return false;
		}
		return true;
	}
	
	static boolean box(int x, int y, int cnt) {
		for(int i = (x/3)*3; i < (x/3)*3 +3; i++) {
			for(int j = (y/3)*3; j < (y/3)*3+3; j++) {
				if(map[i][j] == cnt)
					return false;
			}
		}
	
		return true;
	}
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}