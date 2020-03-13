import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    static ArrayList<Integer> list[];
    static int[] result;
    static int V, E;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t = 1; t<= T; t++) { 
    		st = new StringTokenizer(br.readLine());
    		V = Integer.parseInt(st.nextToken());
    		E = Integer.parseInt(st.nextToken());
    		
    		list = new ArrayList[V+1];
    		for(int i =0; i <= V; i++) { 
    			list[i] = new ArrayList();
    		}
    		
    		result = new int[V+1];
    		for(int i =0; i < E; i++) {
    			st = new StringTokenizer(br.readLine());
    			int num1 = Integer.parseInt(st.nextToken());
    			int num2 = Integer.parseInt(st.nextToken());
    			list[num1].add(num2);
    			list[num2].add(num1);
    		}
    		
    		for(int i =1; i <= V; i++) {
    			if(result[i] ==0)
    				dfs(i, 1);
    		}
    		
    		boolean flag = true;
    		for(int i =1; i<= V; i++) {
    			for(int j : list[i]) {
    				if(result[i] == result[j]) {
    					flag = false;
    					break;
    				}
    			}
    		}
    		
    		if(flag)
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    	}
    	
    }
    
    static void dfs(int idx, int val) { 
    	result[idx] = val;
    	for(int i : list[idx]) { 
    		if(result[i] == 0)
    			dfs(i, val*(-1));
    	}
    }

}