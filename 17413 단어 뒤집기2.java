import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		
		String s = sc.nextLine();
		boolean flag = false;
		
		for(int i =0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch == '<') {
				flag = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(ch);
			}
			else if(ch == '>') {
				flag = false;
				System.out.print(ch);
			}
			else if(flag) {
				System.out.print(ch);
			}
			else {
				if(ch == ' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				}
				else {
					stack.push(ch);
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}