import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String target = br.readLine();
            Stack<Character> stackL = new Stack<>();
            Stack<Character> stackR = new Stack<>();
            for (char c : target.toCharArray()) {
                if (c == '>') {
                    if (stackR.isEmpty()) continue;
                    char temp = stackR.pop();
                    stackL.push(temp);
                } else if (c == '<') {
                    if (stackL.isEmpty()) continue;
                    char temp = stackL.pop();
                    stackR.push(temp);
                } else if (c == '-') {
                    if (stackL.isEmpty()) continue;
                    stackL.pop();
                } else {
                    stackL.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : stackL) {
                sb.append(c);
            }
            if (!stackR.isEmpty()) {
                for (int j = stackR.size() - 1; j >= 0; j--) {
                    sb.append(stackR.get(j));
                }
            }

            System.out.println(sb);
        }
    }
}
