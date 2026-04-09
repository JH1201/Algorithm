import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            PriorityQueue<Long> descPQ = new PriorityQueue<>((a, b) -> b.compareTo(a)); // 내림차순 우선순위 큐
            PriorityQueue<Long> ascPQ = new PriorityQueue<>((a, b) -> a.compareTo(b)); // 오름차순 우선순위 큐
            HashMap<Long, Integer> map = new HashMap<>();

            int K = Integer.parseInt(br.readLine());

            String[] str = new String[2];

            for(int j=0; j<K; j++) {
                /*
                String tmp = br.readLine();
                
                str = tmp.split(" ");
                String command = str[0];
                Long M = (long)Integer.parseInt(str[1]);
                */
                
                // 더 빠른 버전
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                Long M = (long)Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    descPQ.offer(M);
                    ascPQ.offer(M);
                    map.put(M, map.getOrDefault(M, 0) + 1);
                }
                else if(command.equals("D")) {
                    if(M == 1) {
                        
                        // ascPQ 와 동기화
                        while(!descPQ.isEmpty() && map.getOrDefault(descPQ.peek(), 0) == 0) {
                            descPQ.poll();
                        }
                        
                        if(descPQ.peek() == null) continue;
                        
                        Long num = descPQ.poll();
                        map.put(num, map.get(num)-1);
                        
                    }
                    else if(M == -1) {
                        
                        // descPQ 와 동기화
                        while(!ascPQ.isEmpty() && map.getOrDefault(ascPQ.peek(), 0) == 0) {
                            ascPQ.poll();
                        }
                        
                        if(ascPQ.peek() == null) continue;
                        
                        Long num = ascPQ.poll();
                        map.put(num, map.get(num)-1);
                        
                    }
                }
                Arrays.fill(str, "");
            }
            
            // ascPQ 와 동기화
            while(!descPQ.isEmpty() && map.getOrDefault(descPQ.peek(), 0) == 0) {
                descPQ.poll();
            }
            
            // descPQ 와 동기화
            while(!ascPQ.isEmpty() && map.getOrDefault(ascPQ.peek(), 0) == 0) {
                ascPQ.poll();
            }
            
            if(descPQ.isEmpty() || ascPQ.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(descPQ.peek() + " " + ascPQ.peek());
            }
        }
    }
}