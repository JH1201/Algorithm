import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    int num = sc.nextInt();
	    sc.nextLine();
	    String str = sc.nextLine();
	    
	    long sum = 0;
        long r = 1;
        long mod = 1234567891L;
        
	    for(int j=0; j<str.length(); j++) {
	        long t = str.charAt(j) - 'a' + 1;
            
	        sum = (sum + t * r)%mod;
            r = (r * 31)%mod;
	        
	    }
	    
	    System.out.println(sum);
	}
}