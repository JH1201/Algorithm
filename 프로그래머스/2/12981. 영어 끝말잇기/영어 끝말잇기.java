import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int idx = 0;
        int res = 1;
        int i = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(true) {
            
            if(idx >= words.length) {
                answer[0] = 0;
                answer[1] = 0;
                break;
            }
            
            
            
            if(idx > 0) {
                
                String preWord = words[idx-1].substring(words[idx-1].length()-1, words[idx-1].length());
                String nowWord = words[idx].substring(0, 1);
                
                if(!preWord.equals(nowWord)) {
                    answer[0] = i+1;
                    answer[1] = res;
                    break;
                }
                    
            }
            
            if(map.get(words[idx]) == null) {
                map.put(words[idx], 1);
                idx += 1;
                
                if(i == n-1) {
                    i = 0;
                    res++;
                    continue;
                }
                
                i += 1;
                continue;
            }
            
            if(map.get(words[idx]) == 1) {
                answer[0] = i+1;
                answer[1] = res;
                break;
            }
            
        }
        

        return answer;
    }
}