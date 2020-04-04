import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class boj4530 {
    static final int MOD = 1234567891; 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            A = ten(nine(A));
            B = ten(nine(B));
             
            long result = B-A;
            if(A > 0 && B <0 || A< 0 && B > 0)
                result--;
             
                         
            sb.append("#" + t + " " + result + "\n");
 
        }
        System.out.println(sb);
    }
     
     
    static long nine(long val) {
        boolean minus = false;
        if( val < 0) minus = true;
         
        String s = Math.abs(val)+"";
        StringBuilder sb = new StringBuilder();
        if(minus) {
            sb.append("-");
        }
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) -'0'  > 4) {
                sb.append(s.charAt(i)-'1');
            }else
                sb.append(s.charAt(i)-'0');
        }
         
        return Long.parseLong(sb.toString());
    }
     
    static long ten(long val) {
        boolean minus = false;
        if(val < 0) {
            minus = true;
        }
        String s = val + "";
        Long result = 0L;
        Long per = 0L;
         
        for(int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == '-')
                continue;
            result += (s.charAt(i)-'0') * (long)Math.pow(9, per++);
        }
        if(minus)
            result *= -1;
        return result;
    }
     
}
