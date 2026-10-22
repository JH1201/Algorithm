import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    int cnt = 0;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b)-> {
           if(a[0].equals(b[0])) {
               return a[1].compareTo(b[1]);
           }
            return a[0].compareTo(b[0]);
        });
        
        dfs(tickets, "ICN");
        
        
        String[] answer = new String[list.size()];
            
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
 
    public boolean dfs(String[][] t, String curNation) {
        
        if(cnt == t.length) {
            list.add(curNation);
            return true;
        }
        
        for(int i=0; i<t.length; i++) {
            
            if(visited[i]) continue;
            if(t[i][0].equals(curNation)) {
             
                cnt++;
                visited[i] = true;
                list.add(curNation);
                
                if(dfs(t, t[i][1])) {
                    return true;
                }
                
                cnt--;
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    
    
}