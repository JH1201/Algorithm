import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i]; // 올림 연산
            q.add(days);
        }

        while (!q.isEmpty()) {
            int base = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= base) {
                q.poll();
                count++;
            }

            list.add(count);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}