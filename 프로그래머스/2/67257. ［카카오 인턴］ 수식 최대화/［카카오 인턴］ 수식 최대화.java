import java.util.*;

class Solution {
    
    long answer = 0;
    long sum = 0;
    int[] opMap = new int[3];
    boolean[] visited = new boolean[3];
    
    public long solution(String expression) {
        
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> opList = new ArrayList<>();
        
        String numStr = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            
            if(c == '+' || c == '-' || c == '*') {
                numStr = sb.toString();
                opList.add(c);
                numList.add(Long.valueOf(numStr));
                sb = new StringBuilder();
            }
            else if(i == expression.length()-1){
                sb.append(c);
                numStr = sb.toString();
                numList.add(Long.valueOf(numStr));
            }
            else {
                sb.append(c);
            }
        }
        
        for(int i=0; i<3; i++) {
            dfs(numList, opList, i, 0);
        }
        return answer;
    }
    
    /*
    * 0 : +
    * 1 : -
    * 2 : *
    */
    public void dfs(ArrayList<Long> numList, ArrayList<Character> opList, int opCode, int idx) {
        
        if(visited[opCode]) return;
        
        visited[opCode] = true;
        opMap[idx] = opCode;
        
        if(idx == 2) {
            
            ArrayList<Long> copyNumList = new ArrayList<>(numList);
            ArrayList<Character> copyOpList = new ArrayList<>(opList);
            
            for(int i=0; i<3; i++) {
                char op = ' ';
                
                switch (opMap[i]) {
                    case 0 : op = '+'; break;
                    case 1 : op = '-'; break;
                    case 2 : op = '*'; break;
                }
                
                for(int j=0; j<copyOpList.size();) {
                    if(copyOpList.get(j) == op) {
                        long n1 = copyNumList.get(j);
                        long n2 = copyNumList.get(j + 1);
                        long result = 0;
                        
                        if(op == '+') result = n1 + n2;
                        else if(op == '-') result = n1 - n2;
                        else result = n1 * n2;
                        
                        copyNumList.remove(j+1);
                        copyNumList.remove(j);
                        copyNumList.add(j, result);
                        
                        copyOpList.remove(j);
                    }
                    else {
                        j++;
                    }
                }
            }
            
            sum = Math.abs(copyNumList.get(0));
            answer = Math.max(answer, sum);
        }
        
        for(int i=0; i<3; i++) {
            dfs(numList, opList, i, idx+1);
        }
        
        // 백트래킹
        visited[opCode] = false;
    }
}