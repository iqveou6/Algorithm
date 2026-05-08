import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i] && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
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