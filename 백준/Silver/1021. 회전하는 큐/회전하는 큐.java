import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (deque.peekFirst() == target) {
                deque.pollFirst();
                continue;
            }
            int targetIndex = 0;
            for (int number : deque) {
                if (number == target) {
                    break;
                }
                targetIndex++;
            }
            if (deque.size() - targetIndex > targetIndex) {
                while (deque.peekFirst() != target) {
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
                deque.pollFirst();
            } else {
                while (deque.peekFirst() != target) {
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
                deque.pollFirst();
            }
        }
        System.out.println(answer);
    }
}
