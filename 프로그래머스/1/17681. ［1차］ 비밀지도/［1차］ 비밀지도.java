import java.util.*;


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<arr1.length; i++) {
            int tmp = arr1[i] | arr2[i];
            System.out.println(transBinary(tmp, n));
            answer[i] = transBinary(tmp, n);
        }
        
        return answer;
    }
    
    
    public String transBinary(int num, int n) {
        
        String res = "";
        
        while(num > 0) {
            int tmp = num%2;
            res += Integer.toString(tmp);
            num = num/2;
        }
        
        if(res.length() < n) {
            while(res.length() != n) {
                res += "0";
            }
                
        }
        
        StringBuffer str = new StringBuffer(res);
        res = str.reverse().toString();
        
        String result = "";
        for(int i=0; i<res.length(); i++) {
            if(res.charAt(i) == '1') {
                result += "#";
            }
            else {
                result += " ";
            }
        }
        
        return result;
        
    }
}