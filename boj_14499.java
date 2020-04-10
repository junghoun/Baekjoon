import java.util.Scanner;

public class boj_14499 {
	static int[] dic, temp;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0 , 0};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		dic = new int[6];
		temp = new int[6];
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		
		map = new int[N][M];
		for(int i =0; i < N; i++) {
			for(int j =0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		int val = 0;
		for(int i =0; i < K; i++) {
			val = sc.nextInt()-1;
			int nx = x + dx[val];
			int ny = y + dy[val];
			//System.out.println(nx + " " + ny);
			if( nx < 0 || ny < 0 || nx > map.length-1 || ny > map.length-1)
				continue;
			solve(nx, ny, val);
			System.out.println(dic[0]);
			x = nx;
			y = ny;
		}
	}
	// 0 : 동쪽, 1: 서쪽, 2: 북쪽, 3: 남쪽
	static void solve(int nx, int ny, int val) {
		switch(val) {
		// 동쪽
		case 0:
			temp[0] = dic[3];
			temp[1] = dic[2];
			temp[2] = dic[0];
			temp[3] = dic[1];
			temp[4] = dic[4];
			temp[5] = dic[5];
			break;
		// 서쪽
		case 1:
			temp[0] = dic[2];
			temp[1] = dic[3];
			temp[2] = dic[1];
			temp[3] = dic[0];
			temp[4] = dic[4];
			temp[5] = dic[5];
			break;
		// 북쪽
		case 2:
			temp[0] = dic[4];
			temp[1] = dic[5];
			temp[2] = dic[2];
			temp[3] = dic[3];
			temp[4] = dic[1];
			temp[5] = dic[0];
			break;
		// 남쪽
		case 3:
			temp[0] = dic[5];
			temp[1] = dic[4];
			temp[2] = dic[2];
			temp[3] = dic[3];
			temp[4] = dic[0];
			temp[5] = dic[1];
			break;
		}
		
		for(int i =0; i < 6; i++) {
			dic[i] = temp[i];
		}
		
		if(map[nx][ny] == 0) {
			map[nx][ny] = dic[1];
		}
		else {
			dic[1] = map[nx][ny];
			map[nx][ny] = 0;
		}
	}
}
