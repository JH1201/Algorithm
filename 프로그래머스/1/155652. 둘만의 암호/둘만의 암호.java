class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean[] isSkip = new boolean[26];
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : skip.toCharArray()) {
            isSkip[c-'a'] = true;
        }
        
        for(char c : s.toCharArray()) {
            int move = 0;
            
            while(move < index) {
                c++;
                
                if(c > 'z') c = 'a';
                
                if(isSkip[c-'a']) continue;
                move++;
            }
            sb.append(c);
        }
        
        answer = sb.toString();
        
        return answer;
        
    }
}