import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        int len = numbers.length;
        HashSet<Integer> set = new HashSet<>(); // 중복 제거용 Set

        // 두 수의 합을 set에 추가
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        // Set의 중복 없는 값을 ArrayList로 변환 후 정렬
        ArrayList<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer); // 오름차순 정렬

        System.out.println(answer); // 디버깅 출력

        return answer;
    }
}
