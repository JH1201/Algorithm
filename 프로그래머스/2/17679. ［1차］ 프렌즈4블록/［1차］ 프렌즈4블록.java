import java.util.*;

class Solution {
    
    int[][] v;
    
    public int solution(int m, int n, String[] board) {
        
        v = new int[m][n];
        int answer = 0;
        boolean flag = true;
        
        while(flag) {
            
            // 2X2 블럭 찾기 (겹치는 블럭도 찾아야 됨)
            int cnt = getBolck(m, n, board); 
            System.out.println("cnt: " + cnt);
            
            if(cnt == 0) {
                flag = false;
                break;
            } 

            // 아래로 내리기
            board = downTheMap(board);
            
            answer += cnt;
        }
        
        return answer;
    }
    
    public int getBolck(int m, int n, String[] board) {
        
        for(int i=0; i<m-1; i++) {
            
            String s = board[i];
            String nextS = board[i+1];
            
            for(int j=0; j<s.length()-1; j++) {
                
                // 현재 위치를 기준으로 2X2 확인
                // 현재 위치에서 오른쪽, 아래 방향만 확인하면 됨
                
                char curC = s.charAt(j);
                if(curC == ' ') continue;
                if(s.charAt(j+1) == curC && nextS.charAt(j) == curC && nextS.charAt(j+1) == curC) {
                    
                    //System.out.println("현재 위치: " + curC + " / i: " + i + ", j: " + j);
                    
                    v[i][j] += 1; 
                    v[i][j+1] += 1;     // 오른쪽 방문 처리
                    v[i+1][j] += 1;       // 아래 방문 처리
                    v[i+1][j+1] += 1;     // 오른쪽 대각선 방문 처리
                }
                
            }
        }
        
        int removeCnt = 0;    // 지울 블럭 갯수
        int cnt = 0;          // 겹친 블럭 갯수
        
        /*
        for(int i=0; i<v.length; i++) {
            for(int j=0; j<v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        */
        
        for(int i=0; i<v.length; i++) {
            for(int j=0; j<v[i].length; j++) {
                if(v[i][j] >= 1) removeCnt++;
            }
        }
        
        return removeCnt;
    }
    
    public String[] downTheMap(String[] board) {
        
        String[] newMap = new String[board.length];
        
        // 방문된 곳 공백 처리
        for(int i=0; i<v.length; i++) {
            
            String s = board[i];
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<v[i].length; j++) {
                if(v[i][j] >= 1) {
                    sb.append(' ');
                } else {
                    sb.append(s.charAt(j));
                }
            }
            
            newMap[i] = sb.toString();
        }
        
        // 공백 아래로 내리기
        boolean flag = true;
        while(flag) {
            
            int cnt = 0;
            
            for(int i=1; i<newMap.length; i++) {
                String sT = newMap[i];
                String uT = newMap[i-1];

                StringBuilder upStr = new StringBuilder();
                StringBuilder str = new StringBuilder();
                for(int j=0; j<sT.length(); j++) {

                    if(sT.charAt(j) == ' ' && uT.charAt(j) != ' ') {
                        upStr.append(' ');
                        str.append(uT.charAt(j));
                        cnt++;
                    }
                    else {
                        upStr.append(uT.charAt(j));
                        str.append(sT.charAt(j));
                    }

                }
                newMap[i-1] = upStr.toString();
                newMap[i] = str.toString();
            }
            
            if(cnt == 0) {
                flag = false;
                break;
            }
        }
        
        
        // v 초기화
        for(int i=0; i<v.length; i++) {
            for(int j=0; j<v[i].length; j++) {
                v[i][j] = 0;
            }
        }
        
        /*
        for(String tmp : newMap) {
            System.out.println(tmp);
        }
        */
        
        return newMap;
    }
}