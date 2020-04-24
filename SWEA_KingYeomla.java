import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;
 
public class SWEA_KingYeomla {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<= T; t++) {
            int N = Integer.parseInt(br.readLine());        
     
            TreeSet<String> name = new TreeSet<String>(new Comparator<String>() {
                public int compare(String pre, String next) {
                    if(pre.length() != next.length()) { 
                        return pre.length() - next.length();
                    } else {    
                        return pre.compareTo(next);
                    }
                }           
            });
            for(int i =0; i < N; i++) {
                name.add(br.readLine());
            }           
            sb.append("#").append(t).append("\n");
            for (String string : name) {
                sb.append(string + "\n");
            }
        }
        System.out.println(sb);
    }   