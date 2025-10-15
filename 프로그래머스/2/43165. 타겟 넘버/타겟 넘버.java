import java.util.*;

class Solution {
    int answer = 0;
    public void dfs(int[] numbers, int sum, int depth, int target) {
        if (depth == numbers.length) {
            if (target == sum) {
               answer++; 
            }
            return;
        }
        dfs(numbers, sum + numbers[depth], depth+1, target);
        dfs(numbers, sum - numbers[depth], depth+1, target);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
}