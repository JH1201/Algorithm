import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int n : stages) {
            list.add(n);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int tmp : stages) {
            
            if(tmp > N) continue;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            /*else {
                if(map.get(tmp) == null) {
                    map.put(tmp, 1);
                }
                else {
                    map.put(tmp, map.get(tmp)+1);
                }
            }
            */
            
        }
        
        //KeySet() 활용
        /*for(Integer i : map.keySet()){ //저장된 key값 확인
            System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
        }*/
        
        HashMap<Integer, Double> failStatMap = new HashMap<>();
        int remain = stages.length;
        
        for(int stage=1; stage<=N; stage++) {
            int stageCnt = map.getOrDefault(stage, 0);
            double failStat = (remain == 0) ? 0.0 : (double)stageCnt / remain;
            failStatMap.put(stage, failStat);
            remain -= stageCnt;
        }
        
        //KeySet() 활용
        /*for(Integer i : failStatMap.keySet()){ //저장된 key값 확인
            System.out.println("[Key]:" + i + " [Value]:" + failStatMap.get(i));
        }*/
        
        ArrayList<Integer> stageList = new ArrayList<>();
        for (int stage = 1; stage <= N; stage++) stageList.add(stage);

        stageList.sort((a, b) -> {
            int cmp = Double.compare(failStatMap.get(b), failStatMap.get(a)); // 실패율 내림차순
            if (cmp != 0) return cmp;
            return Integer.compare(a, b);                                     // 동률이면 stage 오름차순
        });

        for (int i = 0; i < N; i++) answer[i] = stageList.get(i);

        
        
        return answer;
    }
}