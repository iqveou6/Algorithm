import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static char[][] map;
    public static int[][] fireMap;
    public static int[][] escapeMap;
    public static int h; public static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fireMap = new int[h][w];
            escapeMap = new int[h][w];
            int x = 0; int y = 0;

            Queue<int[]> fireQueue = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '*') {
                        fireQueue.add(new int[]{i, j});
                        fireMap[i][j] = 1;
                    }
                    else if (map[i][j] == '@') {
                        x = i; y = j;
                    }
                }
            }

            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (map[nx][ny] != '#' && fireMap[nx][ny] == 0) {
                        fireMap[nx][ny] = fireMap[cur[0]][cur[1]] + 1;
                        fireQueue.add(new int[]{nx, ny});
                    }
                }
            }
            int ans = bfs(x, y);
            if (ans == -1) {
                answer.append("IMPOSSIBLE").append("\n");
            } else {
                answer.append(ans).append("\n");
            }

        }
        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        escapeMap[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 0 || cur[0] == h - 1 || cur[1] == 0 || cur[1] == w - 1) {
                return escapeMap[cur[0]][cur[1]];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == '.' && escapeMap[nx][ny] == 0) {
                    if (fireMap[nx][ny] == 0 || escapeMap[cur[0]][cur[1]] + 1 < fireMap[nx][ny]) {
                        escapeMap[nx][ny] = escapeMap[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
