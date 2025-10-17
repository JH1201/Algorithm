import java.util.*;

public class Main {
    public static void main(String args[])
    {
        ArrayList<Integer> list_A = new ArrayList<>();
        ArrayList<Integer> list_B = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        String alist = sc.nextLine();
        String[] al = alist.split(" ");

        

        int M =sc.nextInt();
        sc.nextLine();
        String blist = sc.nextLine();
        String[] bl = blist.split(" ");

        for(int i=0; i<N; i++) {
            list_A.add(Integer.parseInt(al[i]));
        }

        for(int i=0; i<M; i++) {
            list_B.add(Integer.parseInt(bl[i]));
        }
        Collections.sort(list_A);

        for(int i=0; i<M; i++) {
            int start = 0;
            int end = N-1;
            int mid;
            boolean flag = false;
            while(end >= start) {
                mid = (start + end) / 2;

                if(list_B.get(i).equals(list_A.get(mid))) {
                    System.out.println("1");
                    flag = true;
                    break;
                } 
                else if(list_B.get(i) < list_A.get(mid)) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            if(!flag) System.out.println("0");
            
        }
    }
}