import java.util.*;

class Solution {
    
    HashSet<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        int answer = 0;
        
        boolean[] v = new boolean[user_id.length];
        
        // 모든 경우 탐색
        // 백트레킹 사용
        dfs(user_id, banned_id, v, 0);
        
        answer = set.size();
        
        return answer;
    }
    
    public void dfs(String[] user_id, String[] banned_id, boolean[] v, int idx) {
        
        if(idx == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<v.length; i++) {
                if(v[i]) sb.append(i);
            }
            
            set.add(sb.toString());
            
            return ;
        }
        
        String bannedNm = banned_id[idx];
            
        for(int j=0; j<user_id.length; j++) {

            if(v[j]) continue;

            if(check(bannedNm, user_id[j])) {

                v[j] = true;

                dfs(user_id, banned_id, v, idx+1);

                v[j] = false;

            }
        }
    }
    
    public boolean check(String bannedNm, String userNm) {
        
        boolean flag = true;
        
        if(bannedNm.length() != userNm.length()) return false;
        
        for(int i=0; i<bannedNm.length(); i++) {
            if(bannedNm.charAt(i) == userNm.charAt(i) || bannedNm.charAt(i) == '*') continue;
            else return false;
        }
        
        return flag;
    }
}