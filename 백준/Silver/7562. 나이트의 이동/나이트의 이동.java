import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    public static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            Queue<int[]> queue = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            queue.add(new int[]{cx, cy});
            map[cx][cy] = 1;

            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            int answer = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == fx && cur[1] == fy) {
                    answer = map[cur[0]][cur[1]] - 1;
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
