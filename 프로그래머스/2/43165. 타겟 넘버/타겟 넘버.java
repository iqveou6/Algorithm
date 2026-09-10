import java.util.*;
class Solution {
    public int answer;
    public void dfs(int[] numbers, int sum, int depth, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, numbers[depth]+sum, depth+1, target);
        dfs(numbers, sum-numbers[depth], depth+1, target);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
}