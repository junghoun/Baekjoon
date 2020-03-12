import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sample = sc.next();
		char[] arr = sample.toCharArray();
		
		int cnt = 0;
		
		
		for(int i =0; i < arr.length; i++) {
			cnt++;
			if(arr[i] == 'c') {
				if(i != arr.length-1 && (arr[i+1] == '=' || arr[i+1] == '-')) {
					i++;
				}
			}
			else if(arr[i] == 'd') {
				if(i != arr.length-1 && arr[i+1] == '-') {
					i++;
				}
				else if (i != arr.length-2 && i != arr.length-1 && arr[i+1] == 'z' && arr[i+2] == '=') {
					i+=2;
				}
				
			}
			else if(arr[i] == 'l') {
				if(i != arr.length-1 && arr[i+1] == 'j') {
					i++;
				}
			}
			else if(arr[i] == 'n') {
				if(i != arr.length-1 && arr[i+1] == 'j') {
					i++;
				}
			}
			else if(arr[i] == 's') {
				if(i != arr.length-1 && arr[i+1] == '=') {
					i++;
				}
			}
			else if(arr[i] == 'z') {
				if(i != arr.length-1 && arr[i+1] == '=') {
					i++;
				}
			}
			
			
		}
		System.out.println(cnt);
		
	}
}
