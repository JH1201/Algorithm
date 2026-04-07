import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] map = new int[N][2];
        
        for(int i=0; i<N; i++) {
            
            int w = sc.nextInt();
            int h = sc.nextInt();
            
            map[i][0] = w;
            map[i][1] = h;
        }
        
        int rank = 1;
        
        ArrayList<Integer> nList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==j) continue;
                
                if (map[j][0] > map[i][0] && map[j][1] > map[i][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
            nList.add(rank);
            rank = 1;
        }
    }
}