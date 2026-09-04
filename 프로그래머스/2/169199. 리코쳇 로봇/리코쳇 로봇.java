import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int r = board.length;
        int c = board[1].length();
        int[][] way = new int[r][c];
        
        int startR = 0;
        int startC = 0;
        int finishR = 0; 
        int finishC = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i].charAt(j) == 'R') {
                    startR = i;
                    startC = j;
                } else if (board[i].charAt(j) == 'D') {
                    way[i][j] = -1;
                } else if (board[i].charAt(j) == 'G') {
                    finishR = i;
                    finishC = j;
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.offer(new int[]{startR, startC});
        way[startR][startC] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int cx = cur[0] + dx[i];
                int cy = cur[1] + dy[i];
                if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
                    continue;
                }
                while (true) {
                    if (way[cx][cy] == -1) break;
                    
                    cx += dx[i];
                    cy += dy[i];
                    
                    if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
                        break;
                    }
                    
                }
                cx -= dx[i];
                cy -= dy[i];
                if (way[cx][cy] == 0) {
                    way[cx][cy] = way[cur[0]][cur[1]] + 1;
                    queue.offer(new int[] {cx, cy});
                }
                
                if (cx == finishR && cy == finishC) {
                    return way[cx][cy] - 1;
                }
                
            }
        }
        for (int i =0;i<r;i++) {
            System.out.println(Arrays.toString(way[i]));
        }
        return -1;
    }
    
}