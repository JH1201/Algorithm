import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int discountLen = discount.length;
        int totalDay = 10;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 회원 자격 일(최대 10일)
        int cnt = 0;
        for(int i=0; i<=discountLen - totalDay; i++) {
            if(!wantMap.containsKey(discount[i])) {
                //discountMap.put(discount[i], discountMap.get(discount[i])-1);
                continue;
            }
            
            boolean flag = true;
            
            for(int j=i; j<i+totalDay; j++) {
                if(j >= discountLen) break;
                
                if(discountMap.getOrDefault(discount[j], 0) == 0) {
                    discountMap.put(discount[j], 1);
                }

                else {
                    discountMap.put(discount[j], discountMap.get(discount[j])+1);
                }
            }
            
            for(int j=i; j<i+totalDay; j++) {
                if(j >= discountLen) break;
                
                //System.out.println("j = " + j + ", discount[j] : " + discount[j] + ", wantMap: " + wantMap.get(discount[j]) + ", discountMap: " + discountMap.get(discount[j]));
                
                if(wantMap.get(discount[j]) != discountMap.get(discount[j])) {
                    flag = false;
                    //System.out.println("flag false break");
                    break;
                }
                
            }
            
            if(flag) answer++;
            discountMap.clear();
        }
        
        return answer;
    }
}