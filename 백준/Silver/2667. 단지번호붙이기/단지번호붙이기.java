import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] map;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    answer.add(bfs(i, j));
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    public static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        map[x][y] = -1;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = -1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}
