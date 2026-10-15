import java.util.*;

class Solution {
    public int[] solution(String s) {
    
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(s.length()-1);
        sb.deleteCharAt(0);
        
        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i) == ',') {
                if(sb.charAt(i+1) == '{') {
                    sb.insert(i, '/');
                    sb.deleteCharAt(i+1);
                }
            }
        }
        
        s = sb.toString().replace("{", "");
        s = s.replace("}", "");
        
        
        ArrayList<ArrayList<Integer>> tupleList = new ArrayList<>();
        ArrayList<Integer> tuple = new ArrayList<>();
        
        StringBuilder numSb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            
            if(s.charAt(i) == '/') {
                tuple.add(Integer.valueOf(numSb.toString()));
                numSb.setLength(0);
                
                tupleList.add(tuple);
                tuple = new ArrayList<>();
            }
        
            else if(s.charAt(i) == ','){
                tuple.add(Integer.valueOf(numSb.toString()));
                numSb.setLength(0);
            }
            
            else {
                numSb.append(s.charAt(i));
            }
        }
        // 마지막 숫자
        tuple.add(Integer.valueOf(numSb.toString()));
        tupleList.add(tuple);
        
        //System.out.println("tupleList size: " + tupleList.size());
        
        //Collections.sort(tupleList);
        tupleList.sort((a, b) -> a.size() - b.size());
        
        /*
        for(ArrayList<Integer> tl : tupleList) {
            for(int i=0; i<tl.size(); i++) {
                System.out.print(tl.get(i) + " ");
            }
             System.out.println();
        }
        */
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        for(int i=0; i<tupleList.size(); i++) {
            
            ArrayList<Integer> tl = tupleList.get(i);
            
            for(int j=0; j<tl.size(); j++) {
                if(ans.contains(tl.get(j))) continue;
                else ans.add(tl.get(j));
            }
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;   
    }
}