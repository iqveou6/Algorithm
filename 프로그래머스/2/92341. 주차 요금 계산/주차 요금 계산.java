import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량 번호 기준 오름차순 자동 정렬
        Map<String, Integer> totalTime = new TreeMap<>();
        Map<String, Integer> inTime = new HashMap<>();

        for (String record : records) {
            String[] input = record.split(" ");
            String[] time = input[0].split(":");
            int cur = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String car = input[1];

            if (input[2].equals("IN")) {
                inTime.put(car, cur);
            } else {
                totalTime.put(car, totalTime.getOrDefault(car, 0) + cur - inTime.remove(car));
            }
        }

        // 미출차 차량 23:59 (1439분) 일괄 처리
        for (String car : inTime.keySet()) {
            totalTime.put(car, totalTime.getOrDefault(car, 0) + 1439 - inTime.get(car));
        }

        // 요금 계산 및 반환 (TreeMap 순회 시 이미 차량 번호 오름차순 정렬 상태)
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        for (int time : totalTime.values()) {
            if (time <= fees[0]) {
                answer[idx++] = fees[1];
            } else {
                // 정수 올림 나눗셈: (A + B - 1) / B
                int extraUnits = (time - fees[0] + fees[2] - 1) / fees[2];
                answer[idx++] = fees[1] + extraUnits * fees[3];
            }
        }

        return answer;
    }
}