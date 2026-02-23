import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];

        Queue<int[]> fire = new ArrayDeque<>();
        Queue<int[]> escape = new ArrayDeque<>();

        int[][] fireMap = new int[r][c];
        int[][] escapeMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'J') {
                    escape.offer(new int[]{i, j});
                    escapeMap[i][j] = 1;
                } else if (map[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                    fireMap[i][j] = 1;
                }
            }
        }

        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 > nx || nx >= r || 0 > ny || ny >= c) {
                    continue;
                }
                if (fireMap[nx][ny] == 0 && map[nx][ny] != '#') {
                    fireMap[nx][ny] = fireMap[cur[0]][cur[1]] + 1;
                    fire.offer(new int[]{nx, ny});
                }
            }
        }


        boolean flag = false;
        int answer = 0;

        while (!escape.isEmpty()) {
            int[] cur = escape.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 > nx || nx >= r || 0 > ny || ny >= c) {
                    flag = true;
                    answer = escapeMap[cur[0]][cur[1]];
                    break;
                }
                if (map[nx][ny] == '.' && escapeMap[nx][ny] == 0) {
                    if (fireMap[nx][ny] == 0 || fireMap[nx][ny] > escapeMap[cur[0]][cur[1]] + 1) {
                        escapeMap[nx][ny] = escapeMap[cur[0]][cur[1]] + 1;
                        escape.offer(new int[]{nx, ny});
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}
