import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lot, int[] win_n) {

        List<Integer> lottos = Arrays.stream(lot).boxed().collect(Collectors.toList());
        List<Integer> win_nums = Arrays.stream(win_n).boxed().collect(Collectors.toList());

        int match = 0;
        int zeroCnt = 0;
        
        int max=0;
        int min=0;

        for (int x : lottos) {
            if (x == 0) zeroCnt++;
            else if (win_nums.contains(x)) match++;
        }

        System.out.println("match : " + match + ", zeroCnt: " + zeroCnt);
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        max = match + zeroCnt;
        min = match;

        return new int[]{rank[max], rank[min]};
    }
}