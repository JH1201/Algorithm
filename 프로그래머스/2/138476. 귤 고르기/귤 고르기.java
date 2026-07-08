import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            int n = tangerine[i];
            if(map.get(n) == null) map.put(n, 1);
            else {
                int tmp = map.get(n);
                map.put(n, tmp+1);
            }
        }
        
        List<Integer> sizeCounts = new ArrayList<>(map.values());  // Map의 value를 배열로 생성
        sizeCounts.sort(Comparator.reverseOrder());  // 배열 내림차순 정렬
        
        for (int count : sizeCounts) {  // sizeCounts 배열 순회
            k -= count;  // k에서 count 값 빼기
            answer++;  // 귤의 종류 +1
            if (k <= 0) {  // 만약 k가 0보다 작거나 같은 경우
                break;  // 반복문 종료
            }
        }
        
        
        return answer;
    }
}