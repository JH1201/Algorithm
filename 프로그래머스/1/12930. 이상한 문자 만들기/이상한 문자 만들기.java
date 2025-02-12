class Solution {
    public String solution(String s) {
        String answer = "";
        
        int check = 1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                check = 1;
                answer += " ";
                continue;
            }
            
            if(check % 2 == 1) {
                answer += Character.toUpperCase(s.charAt(i));
                check += 1;
            }
            else {
                answer += Character.toLowerCase(s.charAt(i));
                check += 1;
            }
        }
        
        return answer;
    }
}