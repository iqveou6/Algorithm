import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int length = genres.length;
        Map<String, Integer> genre_play = new HashMap<>();
        for (int i = 0; i < length; i++) {
            genre_play.put(genres[i], genre_play.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(genre_play.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<String, Integer> entry : list) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (genres[i].equals(entry.getKey())) {
                    temp.add(new int[]{plays[i], i});
                }
            }
            temp.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                else return b[0] - a[0];
            });
            for (int j = 0; j < 2; j++) {
                if (temp.size() <= j) break;
                answer.add(temp.get(j)[1]);
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}