import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            Deque<Character> stack = new ArrayDeque<>();
            String answer = "no";
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (Character.isAlphabetic(c)) continue;
                if (c == '.') continue;
                if (c == ' ') continue;
                if (c == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                        continue;
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
                    if (stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                stack.push(c);
            }
            if (stack.isEmpty() && flag) answer = "yes";
            System.out.println(answer);
        }
    }
}
