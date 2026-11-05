import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1)/2];
        int[][] snail = new int[n][n];
        int[] count = new int[n];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        for (int i = 0; i < n; i++) {
            count[i] = i+1;
        }
        if (n == 1) return new int[] {1};
        int x = 0; int y = 0;
        int dir = 0;
        for (int i = 1; i <= n * (n+1)/2; i++) {
            snail[x][y] = i;
            if (x + dx[dir] == n || y + dy[dir] == n) {
                dir = (dir + 1) % 3;
            }
            x += dx[dir];
            y += dy[dir];
            if (snail[x][y] != 0) {
                x -= dx[dir];
                y -= dy[dir];
                dir = (dir + 1) % 3;
                x += dx[dir];
                y += dy[dir];
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (snail[i][j] != 0) {
                    answer[index++] = snail[i][j];
                } else break;
            }
        }
        return answer;
    }
}