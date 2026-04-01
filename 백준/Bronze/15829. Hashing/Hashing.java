import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    int num = sc.nextInt();
	    sc.nextLine();
	    String str = sc.nextLine();
	    
	    long sum = 0;
	    for(int j=0; j<str.length(); j++) {
	        long t = str.charAt(j) - 'a' + 1;
	        
	        
	        sum = sum + t * (long)Math.pow(31, j);
	        
	    }
	    sum = sum%1234567891;
	    
	    System.out.println(sum);
	}
}