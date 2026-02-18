import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //세로
        int m = Integer.parseInt(st.nextToken()); //가로
        int[][] board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.println(visited[n - 1][m - 1]);
    }
}
