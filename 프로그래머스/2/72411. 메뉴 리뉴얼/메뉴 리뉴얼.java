import java.util.*;

class Solution {
    
    ArrayList<String> ans = new ArrayList<>();
    Queue<String> targetQ = new LinkedList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 메뉴는 최소 2가지 이상의 단품 메뉴
        // 최소 2명 이상의 손님으로부터 주문된 메뉴 조합만 메뉴 후보로 포함
        
        // course 돌면서 targetNum 제한
        // 안에서 orders 반복
        
        for(int i=0; i<course.length; i++) {
            findCourse(orders, course[i]);
            targetQ.clear();
        }
        
        String[] answer = new String[ans.size()];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        Arrays.sort(answer);
       
        return answer;
    }
    
    public void findCourse(String[] orders, int targetNum) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : orders) {
            char[] order = str.toCharArray();
            
            Arrays.sort(order);
            
            // "A", "AB"
            // order에서 targetNum 길이의 문자열 조합
            getTarget(order, targetNum);
            
            // map에 targetQ에 들어있는 조합 카운트
            check(map, targetQ);
        }
        
        // map 돌면서 코스를 가지고 있는 주문이 2개 이상인 것 중 최대값 확인 후 ans에 저장
        int max = 0;
        
        for(String key : map.keySet()) {
            if(map.get(key) > max ) max = map.get(key);
        }
        
        if(max < 2) return;
        
        for(String key : map.keySet()) {
            if(map.get(key) == max) ans.add(key);
        }

    }
    
    
    public void getTarget(char[] order, int targetNum) {
        
        dfs(order, 0, targetNum, "");
    }
    
    public void dfs(char[] order, int idx, int targetNum, String cours) {
        
        if(cours.length() == targetNum) {
            targetQ.add(cours);
            return;
        }
        
        for(int i=idx; i<order.length; i++) {

            dfs(order, i+1, targetNum, cours + order[i]);
        }
        
    }
    
    // map에 targetQ에 들어있는 조합 카운트
    public void check(HashMap<String, Integer> map, Queue<String> targetQ) {
        
        while(!targetQ.isEmpty()) {
            
            String tmpS = targetQ.poll();
            
            int t = map.getOrDefault(tmpS, 0);
            
            map.put(tmpS, t+1);
            
        }
    }
    
}