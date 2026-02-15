import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    answer++;
                    stack.pop();
                }
                continue;
            }
            stack.push(input.charAt(i));
        }
        System.out.println(answer);
    }
}
