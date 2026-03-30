import java.util.*;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag = Arrays.asList(words).contains(target);
        
        if(!flag) return 0; 
        
        bfs(begin, target, words);
        
        if(map.containsKey(target)) {
            answer = map.get(target);
        }
        
        return answer;
    }
    
    public void bfs(String begin, String target, String[] words) {
        
        map.put(begin, 0);
        q.add(begin);
        
        while(!q.isEmpty()) {
            
            String tmpStr = q.poll();  // 현재 문자열
            
            if(tmpStr.equals(target)) return ;
            
            String[] nextWord = findWord(tmpStr, words);
            
            for(int i=0; i<nextWord.length; i++) {
                boolean visited = map.containsKey(nextWord[i]);
                
                if(visited) continue;
                
                map.put(nextWord[i], map.get(tmpStr)+1);
                q.add(nextWord[i]);
            }
        }
        
        
    }
    
    public String[] findWord(String begin, String[] words) {
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(String word : words) {
            int cont = 0;
            
            for(int i=0; i<begin.length(); i++) {
                if(begin.charAt(i) != word.charAt(i)) cont++;
            }
            
            if(cont == 1) {
                answer.add(word);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}