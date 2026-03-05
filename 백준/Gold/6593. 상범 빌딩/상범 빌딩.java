import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static char[][][] map;
    public static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            map = new char[l][r][c];
            visited = new int[l][r][c];
            int x = 0;
            int y = 0;
            int z = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = input.charAt(k);
                        if (map[i][j][k] == 'S') {
                            z = i;
                            x = j;
                            y = k;
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{z, x, y});
            visited[z][x][y] = 1;
            int answer = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nz = cur[0] + dz[i];
                    int nx = cur[1] + dx[i];
                    int ny = cur[2] + dy[i];
                    if (nz < 0 || nz >= l || nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        continue;
                    }
                    if (visited[nz][nx][ny] == 0 && map[nz][nx][ny] == '.') {
                        visited[nz][nx][ny] = visited[cur[0]][cur[1]][cur[2]] + 1;
                        queue.offer(new int[]{nz, nx, ny});
                    }
                    if (map[nz][nx][ny] == 'E') {
                        answer = visited[cur[0]][cur[1]][cur[2]];
                        break;
                    }
                }
                if (answer != 0) break;
            }
            if (answer == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", answer);

            }
        }
    }
}
