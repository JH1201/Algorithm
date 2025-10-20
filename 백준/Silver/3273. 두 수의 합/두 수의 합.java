import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException 
    {

    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();

    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<N; i++) {
        int tmp = sc.nextInt();
        list.add(tmp);
    }

    int K = sc.nextInt();

    Collections.sort(list);

    int left = 0;
    int right = list.size()-1;

    int res = 0;
    while(left < right) {
        int sum = list.get(left) + list.get(right);

        if(sum == K) {
            res++;
            left++;
        }
        else if(sum < K) {
            left++;
        }
        else {
            right--;
        }
    }

    System.out.println(res);
    }

}