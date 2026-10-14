import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        
        
        // 메뉴는 최소 2가지 이상의 단품 메뉴
        // 최소 2명 이상의 손님으로부터 주문된 메뉴 조합만 메뉴 후보로 포함
        
        for(int courseNum : course) {
            
            // 요리 갯수에 맞는 코스 찾기
            ArrayList<String> tmp = findCourse(orders, courseNum);
            
            // 요리 갯수에 맞는 코스가 없을 때
            if(tmp.size() == 0) continue;
            
            for(int i=0; i<tmp.size(); i++) {
                ans.add(tmp.get(i));
            }
        }
        
        
        String[] answer = new String[ans.size()];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        // 오름차순 정렬
        Arrays.sort(answer);
        
        return answer;
    }
    
    public ArrayList<String> findCourse(String[] orders, int targetNum) {
         
         ArrayList<String> res = new ArrayList<>();
         HashMap<String, Integer> map = new HashMap<>();
         
         for(int i=0; i<orders.length; i++) {
             String order = orders[i];
             char[] charArr = order.toCharArray();
             
             Arrays.sort(charArr);
             dfs(charArr, targetNum, 0, "", map);
        }
        
        int max = 0;
        
        for(String key : map.keySet()) {
            if(map.get(key) > 1) {
                max = Math.max(max, map.get(key));
            } 
        }
        
        if(max < 2) return res;
        
        for(String key : map.keySet()) {
            if(map.get(key) == max) {
                res.add(key);
            } 
        }
        return res;
    }

    public void dfs(char[] charArr, int targetNum, int index, String curCombi, HashMap<String, Integer> map) {
        if(curCombi.length() == targetNum) {
            map.put(curCombi, map.getOrDefault(curCombi, 0) + 1);
            return ;
        }
        
        for(int i=index; i<charArr.length; i++) {
            
            //curCombi = curCombi + String.valueOf(charArr[i]);
            dfs(charArr, targetNum, i+1, curCombi+charArr[i], map);
        }
        
    }
}