import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            else {
                stack.push('(');
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}