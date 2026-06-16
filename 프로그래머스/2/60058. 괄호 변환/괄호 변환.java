import java.util.*;

class Solution {

    String u = "";
    String v = "";
    
    public String solution(String p) {
        String answer = "";
        
        answer = seperateStr(p);
        
        return answer;
    }
    
    public String seperateStr(String str) {
        
        if(str.isEmpty()) return "";
        
        StringBuilder sbU = new StringBuilder();
        StringBuilder sbV = new StringBuilder();
    
        int r_cnt=0;
        int l_cnt=0;
        int idx = 0;
        
        // u와 v로 나눔
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') l_cnt++;
            else r_cnt++;
            
            sbU.append(str.charAt(i));
            
            if(r_cnt == l_cnt) {
                idx = i + 1;
                break;
            }
        }
        
        for(int i=idx; i<str.length(); i++) {
            sbV.append(str.charAt(i));
        }
        
        u = sbU.toString();
        v = sbV.toString();
        
        String nU = u;
        String nV = v;
        
        // u가 올바른 문자열일 때
        if(checkRigth(nU)) {
            return nU + seperateStr(nV);
        }
            
        // u가 올바른 문자열이 아닐 때
        else {
            StringBuilder sbT = new StringBuilder();
            
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            sbT.append("(");
            
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            sbT.append(seperateStr(nV));
            
            // 4-3. ')'를 다시 붙입니다.
            sbT.append(")");
            
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            for(int i=1; i<nU.length()-1; i++) {
                if(nU.charAt(i) == '(') sbT.append(")");
                else sbT.append("(");
            }
            
            return sbT.toString();
        }
        
    }
    
    public boolean checkRigth(String str) {
        
        int cnt = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') cnt++;
            else cnt--;
            
            if(cnt < 0) return false;
        }
        
        return cnt == 0;
    }
    
    public boolean checkValence(String str) {
        
        int r = 0;
        int l = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') l++;
            else r++;
        }
        
        return l == r;
    }
}