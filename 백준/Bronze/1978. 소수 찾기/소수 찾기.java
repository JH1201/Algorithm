import java.util.*;

public class Main {
    static int res = 0;
    public static void main(String args[]) throws Exception
    {
        int N;
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0; i<N; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }

        findPrimeNumber(list);

        System.out.println(res);
    }

    static void findPrimeNumber(ArrayList<Integer> arr) {
        for(int num : arr) {

            if(num == 1) continue;

            int check=0;

            for(int i=1; i<=num; i++) {
                if(num % i == 0) check += 1;
            }
            
            if(check == 2) res += 1;
        }
    }
}

