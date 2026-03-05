import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();
        HashMap<String, Integer> totalList = new HashMap<>();

        int totalPlay = 0;

        HashMap<Integer, Integer> playMap = new HashMap<>();

        // 데이터 적재
        for (int i = 0; i < genres.length; i++) {

            // 장르별 전체 플레이수 누적
            totalPlay = totalList.getOrDefault(genres[i], 0);
            totalPlay += plays[i];
            totalList.put(genres[i], totalPlay);

            // 장르별 (고유번호 -> 플레이수) 저장
            playMap = genreMap.getOrDefault(genres[i], new HashMap<>());
            playMap.put(i, plays[i]);
            genreMap.put(genres[i], playMap);
        }

        // 장르 정렬(총 플레이수 내림차순)
        List<Map.Entry<String, Integer>> totalEntryList = new ArrayList<>(totalList.entrySet());
        totalEntryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 결과 수집
        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : totalEntryList) {
            String genre = entry.getKey();
            playMap = genreMap.get(genre);

            // 해당 장르의 곡 정렬(플레이수 내림차순, 고유번호 오름차순)
            List<Map.Entry<Integer, Integer>> playEntryList = new ArrayList<>(playMap.entrySet());
            playEntryList.sort((a, b) -> {
                int cmp = Integer.compare(b.getValue(), a.getValue());
                if (cmp != 0) return cmp;
                return Integer.compare(a.getKey(), b.getKey());
            });

            // 상위 2곡까지 담기
            result.add(playEntryList.get(0).getKey());
            if (playEntryList.size() > 1) {
                result.add(playEntryList.get(1).getKey());
            }
        }

        // int[]로 변환
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}