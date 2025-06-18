import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        int N;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        String num = "666";

        int res = 0;
        int i = 0;
        while(true) {
            if(res == N) break;

            String tmp = Integer.toString(i);
            if(tmp.contains(num)) {
                res += 1;   
                
            } 
            i = Integer.parseInt(tmp) + 1;
            
        }
        
        System.out.println(i-1);
    }
}

