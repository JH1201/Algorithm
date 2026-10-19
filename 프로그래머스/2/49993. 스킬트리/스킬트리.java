import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        for(int i=0; i<skill.length(); i++) {
            q.add(String.valueOf(skill.charAt(i)));
        }
        
        for(String s : skill_trees) {
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<s.length(); i++) {
                String sIndex = String.valueOf(s.charAt(i));
                if(skill.contains(sIndex)) sb.append(sIndex);
            }
            
            // 스킬 나오는 순서
            String st = sb.toString();
            
            // 순서가 skill 순서에 맞는지 확인
            String nextSkill = q.poll();
            boolean flag = true;
            for(int i=0; i<st.length(); i++) {
                String curSkill = String.valueOf(st.charAt(i));
                
                if(curSkill.equals(nextSkill)) {
                    nextSkill = q.poll();
                }
                else {
                    flag = false;
                    break;
                }
                
            }
            
            //System.out.println("s: " + s + ", sb: " + st + ", flag: " + flag);
            
            q.clear();
            for(int i=0; i<skill.length(); i++) {
                q.add(String.valueOf(skill.charAt(i)));
            }
            
            if(flag) answer++;
            
        }
        
        
        return answer;
    }
}