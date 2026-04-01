import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    int num = sc.nextInt();
	    sc.nextLine();
	    String str = sc.nextLine();
	    
	    HashMap<Character, Integer> map = new HashMap<>();
	    
	    for(int i=0; i<26; i++) {
	        char c = (char)('a' + i);
	        
	        map.put(c, i+1);
	        
	    }
	    
	    int sum = 0;
	    for(int j=0; j<str.length(); j++) {
	        char c = str.charAt(j);
	        
	        sum = sum + (int)(map.get(c) * Math.pow(31, j));
	        
	    }
	    sum = sum%1234567891;
	    
	     
	    System.out.println(sum);
		
		
	}
}