import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //세로
        int m = Integer.parseInt(st.nextToken()); //가로
        int[][] board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && visited[i][j] == false) {
                    answer = Math.max(answer, bfs(board, i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(answer);
    }
    public static int bfs(int[][] board, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int temp = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 > nx || nx >= board.length || 0 > ny || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    temp++;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return temp;
    }
}
