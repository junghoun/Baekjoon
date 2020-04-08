import java.util.Scanner;
 
public class JUNGOL_1175 {
    static int[] arr = {1, 2, 3, 4, 5, 6};
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        result = new int[N];
         
        solve(0, M);
         
        sc.close();
    }
     
    public static void solve(int cnt, int M) {
        if(cnt == result.length) {
            int sum = 0;
            for(int i =0; i < result.length; i++) {
                sum += result[i];
            }
            if(sum != M)
                return;
            for(int i =0; i< result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
         
        for (int i = 0; i < arr.length; i++) {
            result[cnt] = arr[i];
            solve(cnt+1, M);
        }
    }
}