class Solution {
    public String solution(int[] food) {
        String answer = "";
        String tmp = "";
        
        for(int i=1; i<food.length; i++) {
            if(food[i]%2 == 0) {
               for(int j=0; j<food[i]/2; j++) {
                    tmp = tmp.concat(Integer.toString(i));
                } 
            }
            else {
                for(int j=0; j<food[i]/2; j++) {
                    tmp = tmp.concat(Integer.toString(i));
                }
                
            }
        }
        
        StringBuffer str = new StringBuffer(tmp);
        
        String tmp2 = str.reverse().toString();
        
        answer = tmp + "0" + tmp2;
        
        //System.out.println(tmp);
        //System.out.println(tmp2);
        return answer;
    }
}