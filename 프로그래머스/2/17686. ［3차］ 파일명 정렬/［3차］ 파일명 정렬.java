import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        ArrayList<String[]> list = new ArrayList<>();
        
        for(String s : files) {
            String head = "";
            String number = "";
            String tail = "";
            
            String[] newString = new String[3];
            StringBuilder sb = new StringBuilder();
            
            // 구분별 문자열 list에 삽입
            for(int i=0; i<s.length(); i++) {
                
                String[] headArr = getHead(s);
                head = headArr[0];
                newString[0] = head;
                //System.out.print("head: " + head);
                
                if(headArr[1] == null) {
                    break;
                }
                else {
                    String[] numberArr = getNumber(headArr[1]);
                    number = numberArr[0];
                    newString[1] = number;
                    //System.out.print(", number: " + number);
                    
                    tail = numberArr[1];
                    newString[2] = tail;
                    //System.out.println(", tail: " + tail);
                }
            }
            
            list.add(newString);
        }
        
        
        // 정렬 기준대로 정렬
        list.sort((a, b) -> {
            if(a[0].toLowerCase().equals(b[0].toLowerCase())) {
                if(Integer.valueOf(a[1]) == Integer.valueOf(b[1])) {
                    return 0; // 점수가 같을 때 들어온대로 반환
                }
                
                else {
                    return Integer.valueOf(a[1]) - Integer.valueOf(b[1]);
                }
            }
            else {
                return a[0].toLowerCase().compareTo(b[0].toLowerCase());
            }
        });
        
        /*
        for(String[] t : list) {
            System.out.println("head: " + t[0] + ", number: " + t[1] + ", tail: " + t[2]);
        }
        */
        
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            StringBuilder stB = new StringBuilder();
            
            String[] t = list.get(i);
            stB.append(t[0]);
            
            if(t[1] != null) {
                stB.append(t[1]);
            }
            
            if(t[2] != null) {
                stB.append(t[2]);
            }
            
            answer[i] = stB.toString();
        }
        
        return answer;
    }
    
    public String[] getHead(String s) {
        
        String[] ans = new String[2];
        int index = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                index = i;
                break;
            }
        }
        
        if(index == 0) {
            ans[0] = s;
            ans[1] = null;
        }
        else {
            ans[0] = s.substring(0, index);
            ans[1] = s.substring(index, s.length());
        }
        
        return ans;
    } 
    
    public String[] getNumber(String s) {
       
        String[] ans = new String[2];
        int index = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(!(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)) {
                index = i;
                break;
            }
        }
        
        if(index == 0) {
            ans[0] = s;
            ans[1] = null;
        }
        else {
            ans[0] = s.substring(0, index);
            ans[1] = s.substring(index, s.length());
        }
        
        return ans;
    } 
}