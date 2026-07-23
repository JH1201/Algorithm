import java.util.*;

class Solution {
    
    Stack<String> s = new Stack<>();
    ArrayList<String> answer = new ArrayList<>();
    boolean[] visited;
    boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        // tickets 정렬
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });        
        
        answer.add("ICN");
        dfs("ICN", tickets, 0);
      
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String curC, String[][] tickets, int cnt)  {
        
        // 탈출 조건
        if(cnt == tickets.length) {
            flag = true;
            return ;
        }
        
        for(int i=0; i<tickets.length; i++) {
            
            if(visited[i]) continue;
            if(!curC.equals(tickets[i][0])) continue;
            
            // 방문 처리
            visited[i] = true;
            String nextCountry = tickets[i][1];
            
            answer.add(nextCountry);
            
            dfs(nextCountry, tickets, cnt+1);
            if(flag) continue;
            visited[i] = false;
            answer.remove(answer.size()-1);
        }
    }
    
}