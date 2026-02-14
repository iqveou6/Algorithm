import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            boolean flag = checkGoodWord(s);
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkGoodWord(String word) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
