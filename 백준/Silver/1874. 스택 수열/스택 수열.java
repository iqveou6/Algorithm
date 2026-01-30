    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 1;
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            while (current <= number) {
                    stack.push(current);
                    answer.add("+");
                    current++;
            }
            if (stack.peek() == number) {
                answer.add("-");
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            for (String s : answer) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
