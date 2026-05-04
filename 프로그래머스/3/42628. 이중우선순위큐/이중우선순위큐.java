import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String operation : operations) {
            String[] info = operation.split(" ");
            if (info[0].equals("I")) {
                int number = Integer.parseInt(info[1]);
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else {
                if (map.isEmpty()) continue;
                int key = 0;
                if (info[1].equals("1")) {
                    key = map.lastKey();
                } else { 
                    key = map.firstKey();
                }
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        if (!map.isEmpty()) {
            int min = map.firstKey();
            int max = map.lastKey();
            answer = new int[]{max, min};
        }
        return answer;
    }
}