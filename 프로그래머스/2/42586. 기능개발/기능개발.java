import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            if (left % speeds[i] == 0) {
                days[i] = left / speeds[i];
            } else {
                days[i] = left / speeds[i] + 1;
            }
        }
        int temp = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            if (temp < days[i]) {
                result.add(count);
                count = 1;
                temp = days[i];
            } else {
                count++;
            }
        }
        result.add(count);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}