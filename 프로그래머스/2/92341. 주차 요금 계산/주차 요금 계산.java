import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");
            int hour = Integer.parseInt(input[0].split(":")[0]);
            int min = Integer.parseInt(input[0].split(":")[1]);
            if (input[2].equals("IN")) {
                recordMap.put(input[1], hour * 60 + min);
            } else {
                totalTimeMap.put(input[1], 
                                 totalTimeMap.getOrDefault(input[1], 0) + hour * 60 + min - recordMap.get(input[1]));
                recordMap.remove(input[1]);
            }
        }
        if (recordMap.size() > 0) {
            for (String key : recordMap.keySet()) {
                totalTimeMap.put(key, 
                                 totalTimeMap.getOrDefault(key, 0) + 23 * 60 + 59 - recordMap.get(key));
            }
        }
        for (String key : totalTimeMap.keySet()) {
            int fee = 0;
            if (totalTimeMap.get(key) <= fees[0]) {
                answer.add(fees[1]);
            } else {
                answer.add(fees[1] + (int)Math.ceil((double)(totalTimeMap.get(key) - fees[0]) / fees[2]) * fees[3]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}