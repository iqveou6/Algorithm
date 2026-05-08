import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x = maps.length;
        int y = maps[0].length;
        int[][] visited = new int[x][y];
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        if (visited[x-1][y-1] != 0) {
            answer = visited[x-1][y-1];
        }
        return answer;
    }
}