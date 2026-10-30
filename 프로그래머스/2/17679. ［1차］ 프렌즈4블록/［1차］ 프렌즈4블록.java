import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] blocks = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            int cnt = 0;
            boolean[][] erase = new boolean[m][n];
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (blocks[i][j] != '.' && blocks[i][j] == blocks[i][j+1] 
                        && blocks[i][j+1] == blocks[i+1][j]
                       && blocks[i+1][j] == blocks[i+1][j+1]) {
                        for (int a = 0; a < 2; a++) {
                            for (int b = 0; b < 2; b++) {
                                erase[i+a][j+b] = true;
                                cnt++;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (erase[i][j]) {
                        blocks[i][j] = '.';
                        answer++;
                    }
                }
            }
            if (cnt == 0) break;
            for (int i = 0; i < n; i++) {
                int count = 0;
                Queue<Character> queue = new ArrayDeque<>();
                for (int j = 0; j < m; j++) {
                    if (blocks[j][i] == '.') {
                        count++; 
                    } else {
                        queue.offer(blocks[j][i]);
                    }
                }
                for (int j = 0; j < count; j++) {
                    blocks[j][i] = '.';
                }
                int index = count;
                while(!queue.isEmpty()) {
                    blocks[index++][i] = queue.poll();
                }
            }
        }
        return answer;
    }
}