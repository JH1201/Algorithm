import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> point = new HashMap<>();
        
        point.put(1, 3);
        point.put(2, 2);
        point.put(3, 1);
        point.put(4, 0);
        point.put(5, 1);
        point.put(6, 2);
        point.put(7, 3);
        
        for(int i=0; i<survey.length; i++) {
            if(choices[i] < 4) {
                if(map.get(survey[i].charAt(0)) == null) {
                    map.put(survey[i].charAt(0), point.get(choices[i]));
                }
                else {
                    int tmp = map.get(survey[i].charAt(0)) + point.get(choices[i]);
                    map.put(survey[i].charAt(0), tmp);
                }
            }
            else if(choices[i] > 4) {
                if(map.get(survey[i].charAt(1)) == null) {
                    map.put(survey[i].charAt(1), point.get(choices[i]));
                }
                else {
                    int tmp = map.get(survey[i].charAt(1)) + point.get(choices[i]);
                    map.put(survey[i].charAt(1), tmp);
                }
            }
        }
        
        char[] category = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(char c : category) {
            System.out.println("c: " + c + " / " +map.get(c));
        }
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < category.length; i += 2) {
            char c1 = category[i];
            char c2 = category[i + 1];

            int score1 = map.get(c1) == null ? 0 : map.get(c1);
            int score2 = map.get(c2) == null ? 0 : map.get(c2);

            if (score1 > score2) {
                answer.append(c1);
            } else if (score1 < score2) {
                answer.append(c2);
            } else {
                // 같으면 사전순 빠른 문자
                if (c1 < c2) {
                    answer.append(c1);
                } else {
                    answer.append(c2);
                }
            }
        }

        
        
        return answer.toString();
    }
}