import java.util.*;

class Solution {
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        // 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 이모티콘 판매액을 최대한 늘리는 것.
        
        
        int serviceRegis = 0;   // 서비스 등록한 사람
        int totalMoney = 0;     // 총 이모티콘 구입 비용
        
        // 이모티콘 별 할인율을 적용한 값의 총 합
        // 할인율 적용할 때 user의 최소 할인율 확인
        
        int[] ratArr = {10, 20, 30 ,40};
        int[][] rateCombi = getCombi(emoticons, ratArr);
        
        for(int i=0; i<rateCombi.length; i++) {
            
            int[] ans = getAnser(users, emoticons, rateCombi[i]);

            serviceRegis = ans[0];
            totalMoney = ans[1];

            if(serviceRegis > answer[0]) {
                answer[0] = serviceRegis;
                answer[1] = totalMoney;
            }
            else if(serviceRegis == answer[0]) {
                answer[1] = Math.max(answer[1], totalMoney);
            }
        }
        
        return answer;
    }
    
    public int[][] getCombi(int[] emoticons, int[] ratArr) {
        int totalCombi = (int)Math.pow(4, emoticons.length);
        int[][] rateCombi = new int[totalCombi][emoticons.length];

        for(int i=0; i<totalCombi; i++) {

            int tmp = i;

            for(int j=0; j<emoticons.length; j++) {

                rateCombi[i][j] = ratArr[tmp % 4];
                tmp /= 4;
            }
        }
        
        return rateCombi;
    }
    
    public int[] getAnser(int[][] users, int[] emoticons, int[] rateArr) {
        int serviceRegis = 0;
        int totalMoney = 0;

        for(int i=0; i<users.length; i++) {
        
            int minRate = users[i][0];
            int avaMoney = users[i][1];

            int usedMoney = 0;

            for(int j=0; j<emoticons.length; j++) {

                if(rateArr[j] >= minRate) {

                    int tmp = emoticons[j] * (100 - rateArr[j]) / 100;
                    usedMoney += tmp;
                }
            }

            if(usedMoney >= avaMoney) {
                serviceRegis++;
            }
            else {
                totalMoney += usedMoney;
            }
        }

        return new int[]{serviceRegis, totalMoney};
    }
}