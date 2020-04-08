import java.util.Scanner;
 
public class JUNGOL_1169 {
    static int[] arr = {1, 2, 3, 4, 5, 6};
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        result = new int[N];
        visited = new boolean[arr.length];
         
        switch(M) {
        case 1:
            solve1(0);
            break;
        case 2:
            solve2(0, 0);
            break;
        case 3:
            solve3(0);
            break;
             
        }
         
    }
    public static void solve1(int cnt) {
        if(cnt == result.length) {
            for(int s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }
         
        for(int i =0; i < arr.length; i++) {
            result[cnt] = arr[i];
            solve1(cnt+1);
             
        }
    }
    public static void solve2(int begin, int cnt) {
        if(cnt == result.length) {
            for(int s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }
         
        for(int i =begin; i < arr.length; i++) {
            result[cnt] = arr[i];
            solve2(i, cnt+1);
             
        }
    }
    public static void solve3(int cnt) {
        if (cnt == result.length) {
            for(int s : result) {
                System.out.print(s+ " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[i] == false) {
                result[cnt] = arr[i];
                visited[i] = true;
                solve3(cnt+1);
                visited[i] = false;
            }
        }
    }
}