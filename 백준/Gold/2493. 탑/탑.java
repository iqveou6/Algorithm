import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tops = new int[n];
        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                sb.append(0).append("\n");
                stack.push(i);
            } else {
                if (tops[i] < tops[stack.peek()]) {
                    sb.append(stack.peek() + 1).append("\n");
                    stack.push(i);
                } else {
                    while (tops[stack.peek()] < tops[i]) {
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                    if (stack.isEmpty()) sb.append(0).append("\n");
                    else {
                        sb.append(stack.peek() + 1).append("\n");
                    }
                    stack.push(i);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
