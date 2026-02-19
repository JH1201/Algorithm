class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean[] isSkip = new boolean[26];
        for(char c :skip.toCharArray()) {
            isSkip[c-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int moved = 0;

            while (moved < index) {
                c++;
                if(c > 'z') c = 'a';
                
                if(isSkip[c - 'a']) continue;
                moved++; 
            }

            sb.append(c);
        }
        
        return sb.toString();
    }
}