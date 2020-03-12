import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i =0; i < N; i++) {
			String s = bf.readLine();
			
			String key = getPwd(s);
			System.out.println(key);
			
		}
	
	}
	public static String getPwd(String pwd) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> pre = new Stack<>();
        Stack<Character> post = new Stack<>();

        for (int i = 0; i < pwd.length(); i++) {
            switch (pwd.charAt(i)) {
                case '<':
                    if (!pre.isEmpty()) post.push(pre.pop());
                    break;
                case '>':
                    if (!post.isEmpty()) pre.push(post.pop());
                    break;
                case '-':
                    if (!pre.isEmpty()) pre.pop();
                    break;
                default:
                    pre.push(pwd.charAt(i));
                    break;
            }
        }
        while (!post.isEmpty()) {
            pre.push(post.pop());
        }
        for (int i = 0; i < pre.size(); i++) {
            sb.append(pre.elementAt(i));
        }
        return sb.toString();
    }
}