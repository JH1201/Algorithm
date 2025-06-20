import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] N = new int[2];

        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<2; i++) {
            N[i] = sc.nextInt();
        }
        sc.nextLine();

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N[0]; i++) {
            String tmp = sc.nextLine();
            
            set.add(tmp);

        }

        int res = 0;
        ArrayList<String> res_list = new ArrayList<>();

        for(int i=0; i<N[1]; i++) {
            String tmp = sc.nextLine();

            if(set.contains(tmp)) {
                res += 1;
                res_list.add(tmp);
            }

        }
       
        Collections.sort(res_list);

        System.out.println(res);

        for(int i=0; i<res_list.size(); i++) {
            System.out.println(res_list.get(i));
        }
    }
}
