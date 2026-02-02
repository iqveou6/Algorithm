import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Deque<long[]> stack = new ArrayDeque<>();
        long answer = 0L;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                answer += stack.peek()[1];
                stack.pop();
            }
            if (stack.isEmpty()) stack.push(new long[] {arr[i], 1});
            else {
                if (stack.peek()[0] == arr[i]) {
                    answer += stack.peek()[1];
                    stack.peek()[1]++;
                    if (stack.size() > 1) answer++;
                } else if (stack.peek()[0] > arr[i]) {
                    answer++;
                    stack.push(new long[]{arr[i], 1});
                }
            }
        }
        System.out.println(answer);
    }
}
