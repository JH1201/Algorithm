import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] allowedWord = {"aya", "ye", "woo", "ma" };
        HashMap<String, Boolean> allowedMap = new HashMap<>();
        
        
        for(String babblingWord : babbling) {
            //System.out.println("Start babblingWord: " + babblingWord);
            allowedMap.put("aya", true);
            allowedMap.put("ye", true);
            allowedMap.put("woo", true);
            allowedMap.put("ma", true);
            
            String tmp = babblingWord;
            
            for(int i=0; i<allowedWord.length; i++) {
                if(tmp.isEmpty()) break;
                
                //System.out.println("i: " + i + ", boolean: " +tmp.startsWith(allowedWord[i]) +", tmp 1: " + tmp);
                if(tmp.startsWith(allowedWord[i])) {
                    //System.out.println("tmp 1: " + tmp);
                    //System.out.println("allow: " + allowedMap.get(allowedWord[i]));
                    
                    if(allowedMap.get(allowedWord[i])) {
                        allowedMap.put("aya", true);
                        allowedMap.put("ye", true);
                        allowedMap.put("woo", true);
                        allowedMap.put("ma", true);
                        
                        allowedMap.put(allowedWord[i], false);
                        tmp = tmp.substring(allowedWord[i].length(), tmp.length());
                        i=-1;
                    }
                    
                    //System.out.println("tmp 2: " + tmp);
                }
            }
            
            if(tmp.isEmpty()) {
                //System.out.println("end babblingWord: " + babblingWord);
                answer++;
            }
        }
        
        return answer;
    }
}