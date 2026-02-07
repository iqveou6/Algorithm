import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] queue = new int[n];
        int head = 0; int tail = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int x ;
            if (commend.equals("push")) {
                    x = Integer.parseInt(st.nextToken());
                    queue[tail++] = x;
            } else if (commend.equals("pop")) {
                if (head == tail) sb.append(-1).append("\n");
                else {
                    sb.append(queue[head]).append("\n");
                    head++;
                }
            } else if (commend.equals("size")) {
                sb.append(tail - head).append("\n");
            } else if (commend.equals("empty")) {
                if (head == tail) sb.append("1").append("\n");
                else sb.append(0).append("\n");
            } else if (commend.equals("back")) {
                if (head == tail) sb.append(-1).append("\n");
                else sb.append(queue[tail - 1]).append("\n");
            } else if (commend.equals("front")) {
                if (head == tail) sb.append(-1).append("\n");
                else sb.append(queue[head]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
