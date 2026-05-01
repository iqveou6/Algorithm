import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            int left = 100 - progresses[i];
            if (left % speeds[i] == 0) {
                days[i] = left / speeds[i];
            } else {
                days[i] = left / speeds[i] + 1;
            }
        }
        int fin = days[0];
        int number = 1;
        for (int i = 1; i < days.length; i++) {
            if (fin < days[i]) {
                answer.add(number);
                number = 1;
                fin = days[i];
            } else {
                number++;
            }
        }
        answer.add(number);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}