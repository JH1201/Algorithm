import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {
        int N;
        int[] arr = new int[6];
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0; i<6; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = new int[2];

        for(int i=0; i<2; i++) {
            temp[i] = sc.nextInt();
        }
        

        int arr_T = 0;

        for(int i=0; i<6; i++) {
            arr_T += (arr[i] + temp[0] - 1) / temp[0];
        }

        // 마스크 팩 수 및 나머지
        int maskPacks = N / temp[1];
        int leftoverMasks = N % temp[1];

        System.out.println(arr_T);
        System.out.println(maskPacks + " " + leftoverMasks);
    }
}

