import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 > nx || nx >= maps.length || 0 > ny || ny >= maps[0].length) {
                    continue;
                }
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny] == true) continue;
                maps[nx][ny] = maps[x][y] + 1;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        if (maps[maps.length-1][maps[0].length-1] == 1) return -1;
        return maps[maps.length-1][maps[0].length-1];
    }
}