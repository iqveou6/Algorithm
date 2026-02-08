import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] deque = new int[2 * n + 1];
        int head = n;
        int tail = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int number = 0;
            if (commend.contains("push")) {
                number = Integer.parseInt(st.nextToken());
            }
            if (commend.equals("push_front")) {
                deque[--head] = number;
            } else if (commend.equals("push_back")) {
                deque[tail++] = number;
            } else if (commend.equals("pop_front")) {
                if (tail - head == 0) sb.append(-1).append("\n");
                else {
                    sb.append(deque[head++]).append("\n");
                }
            } else if (commend.equals("pop_back")) {
                if (tail - head == 0) sb.append(-1).append("\n");
                else {
                    sb.append(deque[tail - 1]).append("\n");
                    tail--;
                }
            } else if (commend.equals("size")) {
                sb.append(tail - head).append("\n");
            } else if (commend.equals("empty")) {
                if (tail - head == 0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (commend.equals("front")) {
                if (tail - head == 0) sb.append(-1).append("\n");
                else sb.append(deque[head]).append("\n");
            } else if (commend.equals("back")) {
                if (tail - head == 0) sb.append(-1).append("\n");
                else {
                    sb.append(deque[tail - 1]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
