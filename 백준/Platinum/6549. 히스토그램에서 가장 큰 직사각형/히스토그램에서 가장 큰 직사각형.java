import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            long[] arr = new long[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            arr[n] = -1L;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            long answer = 0L;
            for (int i = 0; i <= n; i++) {
                while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                    int right = i - 1;
                    int left = 0;
                    long height = arr[stack.peek()];
                    stack.pop();
                    if (stack.peek() == -1) {
                        left = 0;
                    } else {
                        left = stack.peek() + 1;
                    }
                    int width = right - left + 1;
                    answer = Math.max(answer, height * width);
                }
                stack.push(i);
            }
            System.out.println(answer);
        }

    }
}
