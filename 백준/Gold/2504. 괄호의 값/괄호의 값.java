import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        boolean flag = true;
        for (Character c : input.toCharArray()) {
            int temp = 0;
            if (c == ')') {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                if (stack.peek() == -1) {
                    stack.pop();
                    stack.push(2);
                }
                else if (stack.peek() > 0) {
                    while (true) {
                        if (stack.isEmpty()) {
                            flag = false;
                            break;
                        }
                        if (stack.peek() == -1) {
                            stack.pop();
                            temp *= 2;
                            stack.push(temp);
                            break;
                        }
                        temp += stack.pop();
                    }
                }
                else {
                    flag = false;
                    break;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                if (stack.peek() == -2) {
                    stack.pop();
                    stack.push(3);
                }
                else if (stack.peek() > 0) {
                    while (true) {
                        if (stack.isEmpty()) {
                            flag = false;
                            break;
                        }
                        if (stack.peek() == -2) {
                            stack.pop();
                            temp *= 3;
                            stack.push(temp);
                            break;
                        }
                        temp += stack.pop();
                    }
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            if (c == '(') stack.push(-1);
            else if (c == '[') stack.push(-2);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() < 0) {
                answer = 0;
                break;
            }
            answer += stack.pop();

        }
        System.out.println(answer);
    }
}
