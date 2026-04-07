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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        double sum = 0;
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            list.add(tmp);
            sum += (double)tmp;
        }
    
        Collections.sort(list);
        
        for(int i : list) {
            if(map.get(i) == null) {
                map.put(i, 1);
            }
            else {
                int t = map.get(i);
                map.put(i, t+1);
            }
        }
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if(max < map.get(key)) max = map.get(key);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if(max == map.get(key)) pQ.offer(key);
        }
        
        int res = 0;
        if(pQ.size() > 1) {
            pQ.poll();
        } 
        res = pQ.poll();
        
        
        System.out.println(Math.round(sum/N));
        System.out.println(Math.round(list.get(N/2)));
        System.out.println(res);
        System.out.println(list.get(list.size()-1) - list.get(0));
        
       
    }
}