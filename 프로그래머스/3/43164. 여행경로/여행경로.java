import java.util.*;

class Solution {
    
    ArrayList<String> answer = new ArrayList<>();
    boolean[] visited;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        answer.add("ICN");
        visited = new boolean[tickets.length];
        dfs("ICN",tickets, 0);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String first, String[][] tickets, int count) {
        
        if(found) return;
        
        if(count == tickets.length) {
            found = true;
            return ;
        }
        
        for(int i=0; i<tickets.length; i++) {
            
            if(visited[i]) {
                continue;
            }
            
            if(tickets[i][0].equals(first)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count+1);
                
                if(found) return;
                
                visited[i] = false;
                answer.remove(answer.size()-1);
            }
        }
    }
}