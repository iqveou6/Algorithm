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
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast()[1] > arr[i]) {
                deque.pollLast();
            }
            if (i - l + 1 >= 0) {
                while (!deque.isEmpty() && deque.peekFirst()[0] < i - l + 1) {
                    deque.pollFirst();
                }
            }
            deque.offerLast(new Integer[] {i, arr[i]});
            sb.append(deque.peekFirst()[1]).append(" ");
        }
        System.out.println(sb);
    }
}
