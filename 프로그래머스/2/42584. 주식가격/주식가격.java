import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer[]> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < stack.peek()[1]) {
                Integer[] top = stack.pop();
                answer[top[0]] = i - top[0];
            }    
            stack.push(new Integer[] {i, prices[i]}); 
        }
        while (!stack.isEmpty()) {
            Integer[] cur = stack.pop();
            answer[cur[0]] = prices.length - 1 - cur[0];
        }
        return answer;
    }
}