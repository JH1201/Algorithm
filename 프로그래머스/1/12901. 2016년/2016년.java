import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        // 특정 날짜 설정 (2025년 3월 1일)
        LocalDate date = LocalDate.of(2016, a, b);
        
        // 요일 가져오기 (Enum 형태: SATURDAY)
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        System.out.println(dayOfWeek);
        
        // 영어로 가져오기
        String eng = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        //System.out.println(eng);
        answer = eng.toUpperCase();
        
        return answer;
    }
}