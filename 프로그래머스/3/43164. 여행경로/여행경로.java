import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    int cnt = 0;
    
    public String[] solution(String[][] tickets) {
        
        
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } 
            return a[0].compareTo(b[0]);
        });
        
        dfs(tickets, "ICN");
      
        return list.toArray(new String[0]);
    }
    
    public boolean dfs(String[][] tickets, String next) {
        
        if(cnt == tickets.length) {
            list.add(next);
            return true;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(visited[i]) continue;
            if(tickets[i][0].equals(next)) {
                cnt++;
                visited[i] = true;
                list.add(next);
                
                // 이 경로로 모든 티켓 사용에 성공
                if(dfs(tickets, tickets[i][1])) {
                    return true;
                }
                
                // 아닌 경로일 때
                cnt--;
                visited[i] = false;
                list.remove(list.size()-1);
                
            } 
        }
        
        return false;
        
    }
    
}