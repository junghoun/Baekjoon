import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class 백준_좋은수열_2661 {
    
    static int[] arr;
    static boolean flag;
    
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N  = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        
        bfs("");
    }
    
    public static void bfs(String str) {
        if(flag) return;
        
        if(str.length() == arr.length) {
            System.out.println(str);
            flag = true;
            return;
        }
        
        for(int i= 1; i <= 3; i++) {
            if(isOk(str+i)) {
                bfs(str+i);
            }
        }
    }
    public static boolean isOk(String str) {
        int size = str.length();
 
        for(int i = 1; i <= size/2; i++) {
            String first = str.substring(str.length()-i-i, str.length()-i);
            String second = str.substring(str.length()-i, str.length());
            
            if(first.equals(second)) return false;
        }
        
        return true;
    }
}
