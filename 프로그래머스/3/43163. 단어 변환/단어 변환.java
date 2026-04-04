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
        
        q.offer(begin);
        map.put(begin, 0);
        
        while(!q.isEmpty()) {
            
            String curWord = q.poll();
            
            if(curWord.equals(target)) return;
            
            String[] nextWord = findWord(curWord, words);
            
            for(int i=0; i<nextWord.length; i++) {
                
                String nw = nextWord[i];
                boolean visited = map.containsKey(nw);
                
                if(visited) continue;
                
                map.put(nw, map.get(curWord)+1);
                q.offer(nw);
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