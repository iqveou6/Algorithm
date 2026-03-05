import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static int f;
    public static int s;
    public static int g;
    public static int u;
    public static int d;
    public static int[] dx;
    public static int[] visited = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        f = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        g = Integer.parseInt(input[2]);
        u = Integer.parseInt(input[3]);
        d = Integer.parseInt(input[4]);
        dx = new int[]{u, d * -1};
        bfs();
        if (visited[g] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(visited[g] - 1);
        }
    }
    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == g) {
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = cur + dx[i];
                if (next > f || next < 1) continue;
                if (visited[next] == 0) {
                    visited[next] = 1;
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
