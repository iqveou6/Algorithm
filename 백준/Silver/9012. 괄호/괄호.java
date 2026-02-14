import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            String answer = "YES";
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.add(c);
                } else if (c == ')') {
                   if (!stack.isEmpty() && stack.peek() == '(') {
                       stack.pop();
                   } else {
                       answer = "NO";
                       break;
                   }
                }
            }
            if (!stack.isEmpty()) {
                answer = "NO";
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
