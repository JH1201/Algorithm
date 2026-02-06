import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        
        
        Stack<String> cards1_list = new Stack<>();
        Stack<String> cards2_list = new Stack<>();
        Stack<String> goal_list = new Stack<>();
        
        // cards1 -> stack (배열의 0번이 stack의 top이 되게)
        for (int i = cards1.length - 1; i >= 0; i--) {
            cards1_list.push(cards1[i]);
        }

        // cards2 -> stack
        for (int i = cards2.length - 1; i >= 0; i--) {
            cards2_list.push(cards2[i]);
        }

        // goal -> stack
        for (int i = goal.length - 1; i >= 0; i--) {
            goal_list.push(goal[i]);
        }
        
        
        while(!goal_list.isEmpty()) {
            String goal_w = goal_list.peek();
            
            if(!cards1_list.isEmpty()) {
                if(cards1_list.peek().equals(goal_w)) {
                    System.out.println(cards1_list.peek());
                    cards1_list.pop();
                    goal_list.pop();
                    continue;
                }
                
            }
            if(!cards2_list.isEmpty()) {
                if(cards2_list.peek().equals(goal_w)) {
                    System.out.println(cards2_list.peek());
                    cards2_list.pop();
                    goal_list.pop();
                    continue;
                }
            }
            
            
            
            break;
        }
        
        if(goal_list.isEmpty()) {
            answer = "Yes";
        }
        
        
        return answer;
    }
}