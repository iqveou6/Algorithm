import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) ->
                   Integer.compare(a[0], b[0]));
        int start = targets[0][0];
        int end = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            if (end > targets[i][0]) {
                start = Math.max(start, targets[i][0]);
                end = Math.min(end, targets[i][1]);
            } else {
                start = targets[i][0];
                end = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}