import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        Map<String, Integer> cost = new HashMap<>();
        for(String record : records) {
            String[] input = record.split(" ");
            String[] time = input[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            int cur = hour * 60 + min;
            if (input[2].equals("IN")) {
                map.put(input[1], cur);
            } else {
                total.put(input[1], total.getOrDefault(input[1], 0) + cur - map.get(input[1]));
                map.remove(input[1]);
            }
        }
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                total.put(key, total.getOrDefault(key, 0) + 1439 - map.get(key));
            }
        }
        for (String key: total.keySet()) {
            int fee = 0;
            if (total.get(key) >= fees[0]) {
                fee = fees[1] + (int)Math.ceil((double)(total.get(key)-fees[0]) / fees[2])* fees[3];
                
            } else {
                fee = fees[1];
            }
            cost.put(key, fee);
        }
        String[] keys = cost.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        answer = new int[keys.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = cost.get(keys[i]);
        }
        return answer;
    }
}