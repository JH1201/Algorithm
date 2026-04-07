import java.util.*;
import java.io.*;

public class Main
{
    
    public static void main(String[] args) throws Exception {
        
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //int N = sc.nextInt();
        //sc.nextLine();
        
        int N = Integer.parseInt(br.readLine());
        
        int cutNum = (int)Math.round(N * 0.15);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            //int tmp = sc.nextInt();
            int tmp = Integer.parseInt(br.readLine());
            
            list.add(tmp);
        }
        
        Collections.sort(list);
        
        //System.out.println("cutNum :" + cutNum);
        
        double sum = 0;
        int c = 0;
        for(int i=0; i<list.size(); i++) {
            if(i < cutNum || N-i-1 < cutNum) {
                c++;
                continue;
            }
            
            sum += (double)list.get(i);
        }
        
        //System.out.println("c :" + c + ", sum : " + sum);
        
        double r = (double)sum/(N-c);
        //System.out.println("r :" + r);
        
        System.out.println((int)Math.round(r));
       
    }
}