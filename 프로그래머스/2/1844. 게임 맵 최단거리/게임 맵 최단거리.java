import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int r = maps.length; int c = maps[0].length;
        int[][] visited = new int[r][c];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = cur[0] + dx[i];
                int cy = cur[1] + dy[i];
                if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
                    continue;
                }
                if (maps[cx][cy] == 1 && visited[cx][cy] == 0) {
                    visited[cx][cy] = visited[cur[0]][cur[1]] + 1;
                    if (cx == r-1 && cy == c-1) 
                        return visited[cx][cy];
                    queue.offer(new int[]{cx, cy});
                }
            }
        }
        
        return -1;
    }
}