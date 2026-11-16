import java.util.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String answer = "";
        String tmp = "";

        StringBuilder sb = new StringBuilder();

        for(int i=str2.length(); i>0; i--) {
            if(i == str2.length()) {
                tmp = str2;
            }
            else {
                tmp = str2.substring(0, i);
            }
            

            //System.out.println(i + "번째: " + tmp);
            boolean flag1 = checkFlag(str1, tmp);
            boolean flag2 = checkFlag(str2, tmp);

            if(flag1 && flag2) {
                answer = tmp;
                break;
            }

        }

        return answer;

    }

    public boolean checkFlag(String str1, String tmp) {

        if(str1.length() < tmp.length()) return false;

        boolean flag = false;
        String tmp2 = tmp;

        while(tmp2.length() <= str1.length()) {
            
            if(tmp2.equals(str1)) {
                
                flag = true;
                break;
            }
            else {
                tmp2 += tmp;
            }
        }

        return flag;
    }
}