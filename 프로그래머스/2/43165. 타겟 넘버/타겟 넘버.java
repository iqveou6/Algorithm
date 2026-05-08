import java.util.*;

class Solution {
    public int answer = 0;
    public int t;
    public void dfs(int depth, int[] numbers, int num) {
        if (depth == numbers.length) {
            if (t == num) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, numbers, num + numbers[depth]);
        dfs(depth + 1, numbers, num - numbers[depth]);
    }
    public int solution(int[] numbers, int target) {
        t = target;
        dfs(0, numbers, 0);
        return answer;
    }
}