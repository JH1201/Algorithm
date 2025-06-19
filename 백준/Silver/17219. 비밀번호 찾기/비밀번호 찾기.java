import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception
    {
        int[] N = new int[2];

        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<2; i++) {
            N[i] = sc.nextInt();
        }
        sc.nextLine();
        
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<N[0]; i++) {
            String arr = sc.nextLine();
            String[] emailAndPass = arr.split(" ");
            map.put(emailAndPass[0], emailAndPass[1]);
        }

        for(int j=0; j<N[1]; j++) {
            String tmp = sc.nextLine();
            System.out.println(map.get(tmp));
        }
    }

   
}
