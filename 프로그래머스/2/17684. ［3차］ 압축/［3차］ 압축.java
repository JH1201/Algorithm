import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> dic = new HashMap<>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int nextNum = 27;
        
        // 사전 초기화
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            dic.put(String.valueOf(c), i+1);
            
        }
        
        int i = 0;
        while(i<msg.length()) {
            char c = msg.charAt(i);
            String tmp = String.valueOf(c);
            
            boolean added = false;
            
            StringBuilder sb = new StringBuilder();
            
            sb.append(c);
            
            int cnt = 0;
            for(int j=i+1; j<msg.length(); j++) {
                    
                char nextC = msg.charAt(j);
                sb.append(String.valueOf(nextC));
                
                if(dic.get(sb.toString()) == null) {
                    
                    //System.out.println("1 " + sb.toString());
                    
                    answer.add(dic.get(tmp));
                    dic.put(sb.toString(), nextNum);
                    nextNum++;
                    i += tmp.length();
                    added = true;
                    break;
                }
                else {
                    tmp = sb.toString();
                }
            }
            
            if(!added) {
                answer.add(dic.get(tmp));
                i += tmp.length();
            }
            
        }
        
        int[] ans = new int[answer.size()];
        
        for(int k=0; k<answer.size(); k++) {
            ans[k] = answer.get(k);
        }
        
        
        return ans;
    }
}