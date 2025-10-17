import java.util.*;

public class Main {
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        int cont = 0;

        String[] arr = s.split(" ");
        ArrayList<Integer> tmpe = new ArrayList<>();

        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);


        // 1. 선택 절차
        for(int i=0; i<N; i++) {
            int tmp = sc.nextInt();
            tmpe.add(tmp);
        }

        Collections.sort(tmpe, Collections.reverseOrder());
        
        // 2. 적절성 검사 
        for(int i=0; i<N; i++) {
            if (K == 0) break; 
            if ((K / tmpe.get(i)) == 0) { // 이 동전으로는 몫이 0이면 건너뜀
                continue;
            } else {
                cont += K / tmpe.get(i);
                K %= tmpe.get(i);
            }
        }
        System.out.println(cont);

    }
}

