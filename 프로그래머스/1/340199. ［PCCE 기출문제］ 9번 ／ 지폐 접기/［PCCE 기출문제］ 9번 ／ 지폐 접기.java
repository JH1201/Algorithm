class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int maxBill = 2001;
        int minBill = 9;
        int maxWallet = 101;
        int minWallet = 9;
        
        if(bill[1] < bill[0]) {
            maxBill = bill[0];
            minBill = bill[1];
        }
        else {
            maxBill = bill[1];
            minBill = bill[0];
        }
        
        if(wallet[1] < wallet[0]) {
            maxWallet = wallet[0];
            minWallet = wallet[1];
        }
        else {
            maxWallet = wallet[1];
            minWallet = wallet[0];
        }
        
        while(minBill > minWallet || maxBill > maxWallet) {
            answer++;
            maxBill = maxBill/2;
            if(maxBill < minBill) {
                int tmp = minBill;
                minBill = maxBill;
                maxBill = tmp;
            }
            
        }
        
        return answer;
    }
}