import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            numbers[i] = number.charAt(i) - '0';
        }
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (k == 0) {
                stack.push(numbers[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < numbers[i] && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(numbers[i]);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            answer.append(String.valueOf(stack.pop()));
        }
        return answer.reverse().toString();
    }
}