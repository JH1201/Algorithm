import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Character, Integer> map = new HashMap<>();
		
	    String num = sc.nextLine();
	    
	    int sum = 0;
	    
	    int value = 0;
	    
	    for(int i=0; i<num.length(); i++) {
	        char c = num.charAt(i);
	        
	        value = (i % 2) == 0 ? 1 : 3; 
	        
	        if(c == '*') {
	            map.put('*', value);
	        }
	        else {
	            int cNum = c - '0';
	            sum = sum + value*cNum;
	        }
	    }
	    
	    
	    int x = 0;
	    while(true) {
	        if((sum + map.get('*')*x)%10 == 0) break;
	        else x++;
	    }
	    
	    System.out.println(x);
	    
	}
}