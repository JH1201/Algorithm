import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }
        list.sort(Comparator.naturalOrder());

        int count = 0;

        for(int k=0; k<N; k++) {
            int goalVal = list.get(k);

            int i = 0;
            int j = N-1;

            while(i<j) {
                if(list.get(i) + list.get(j) == goalVal) {
                    if(i != k && j != k) {
                        count++;
                        break;
                    }
                    else if(i == k) {
                        i++;
                    }
                    else {
                        j--;
                    }
                }

                else if(list.get(i) + list.get(j) > goalVal) {
                    j--;
                }

                else {
                    i++;
                }
            }

        }
        System.out.println(count);
    }
}