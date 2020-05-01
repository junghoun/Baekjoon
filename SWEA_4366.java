import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_4366 {
	static int[] bin, tri;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		char[] two, three;
		for(int t =1; t<= T; t++) {
			
			two = br.readLine().toCharArray();
			three = br.readLine().toCharArray();
			bin = getBin(two);
			tri = getTri(three);
			

			
	loop:	for(int i =0; i < bin.length; i++) {
				for(int j =0; j < tri.length; j++) {
					if(bin[i]==tri[j]) {
						sb.append("#" + t + " " + bin[i] + "\n");
						break loop;
					}
				}
			}
		}
		System.out.println(sb);
	}
	
	
	static int[] getBin(char[] arr) {
		int[] result = new int[arr.length];
		
		int sum = 0;
		int mul = 1;
		for(int i = arr.length-1; i>=0; i--, mul*=2) {
			if(arr[i]=='1')
				sum += mul;
		}
		mul = 1;
		int idx = 0;
		
		for(int i = arr.length-1; i>=0; i--, mul*=2 ) {
			if(arr[i]=='1')
				result[idx++] = sum-mul;
			else
				result[idx++] = sum+mul;
		}
		return result;
	}
	
	static int[] getTri(char[] arr) {
		int[] result = new int[arr.length*2];
		
		int sum = 0;
		int mul = 1;
		
		for(int i = arr.length-1; i >=0; i--,mul*=3) {
			if(arr[i] =='1')
				sum += mul;
			else if(arr[i] == '2')
				sum += mul*2;
		}
		
		mul = 1;
		int idx = 0;
		
		for(int i = arr.length-1; i>=0; i--, mul*=3) {
			if(arr[i] == '1') {
				result[idx++] = sum-mul;
				result[idx++] = sum+mul;
			}else if(arr[i] == '2') {
				result[idx++] = sum-mul;
				result[idx++] = sum-mul*2;
			}else {
				result[idx++] = sum+mul;
				result[idx++] = sum+mul*2;
			}
		}
		return result;
	}
}
