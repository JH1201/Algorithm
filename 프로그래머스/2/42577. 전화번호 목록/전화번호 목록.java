import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
            else answer = true;
        }
        
        
        return answer;
    }
}