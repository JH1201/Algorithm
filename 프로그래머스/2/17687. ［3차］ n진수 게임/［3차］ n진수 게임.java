class Solution {
    
    
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder();
        int num = 0;

        // 튜브가 필요한 글자 수만큼 충분히 만들어 둔다
        while (all.length() < t * m) {
            all.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        StringBuilder answer = new StringBuilder();

        // 튜브의 차례: p-1, p-1+m, p-1+2m ...
        for (int i = 0; i < t; i++) {
            answer.append(all.charAt((p-1) + i*m));
        }

        return answer.toString();
    }

    
}