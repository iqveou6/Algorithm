import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n, 0});

        int[] visited = new int[200001];
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == k) {
                System.out.println(0);
                break;
            }
            if (cur[0] - 1 >= 0 && cur[0] - 1 < 200001 && visited[cur[0] - 1] == 0) {
                if (cur[0] - 1 == k) {
                    System.out.println(cur[1] + 1);
                    break;
                }
                queue.offer(new int[]{cur[0] - 1, cur[1] + 1});
                visited[cur[0] - 1] = 1;
            }
            if (cur[0] + 1 < 200001 && visited[cur[0] + 1] == 0) {
                if (cur[0] + 1 == k) {
                    System.out.println(cur[1] + 1);
                    break;
                }
                queue.offer(new int[]{cur[0] + 1, cur[1] + 1});
                visited[cur[0] + 1] = 1;
            }
            if (cur[0] * 2 < 200001 && visited[cur[0] * 2] == 0) {
                if (cur[0] * 2 == k) {
                    System.out.println(cur[1] + 1);
                    break;
                }
                queue.offer(new int[]{cur[0] * 2, cur[1] + 1});
                visited[cur[0] * 2] = 1;
            }
        }
    }
}
