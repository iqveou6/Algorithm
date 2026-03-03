import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static List<Integer> area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        area = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    map[x][y]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = -1;
                    area.add(bfs(i, j));
                    answer++;
                }
            }
        }
        Collections.sort(area);

        System.out.println(answer);
        for (int ans : area) {
            System.out.print(ans + " ");
        }
    }
    public static int bfs(int x, int y) {
        int temp = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            temp++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    map[nx][ny] = -1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return temp;
    }
}
