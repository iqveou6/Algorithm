import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] block = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                block[i][j] = board[i].charAt(j);
            }
        }
        boolean[][] erase = new boolean[m][n];
        boolean flag = false;
        while (true) {
            flag = false;
            erase = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char a = block[i][j];
                    char b = block[i][j+1];
                    char c = block[i+1][j];
                    char d = block[i+1][j+1];
                    if (a != '.' && a == b && b == c && c == d) {
                        flag = true;
                        erase[i][j] = true;
                        erase[i][j+1] = true;
                        erase[i+1][j] = true;
                        erase[i+1][j+1] = true;
                    }
                }
            }
            if (!flag) break;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (erase[i][j]) {
                        block[i][j] = '.';
                        answer++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Deque<Character> stack = new ArrayDeque<>();
                int count = 0;
                for (int j = 0; j < m; j++) {
                    if (block[j][i] != '.') {
                        stack.push(block[j][i]);
                    } else {
                        count++;
                    }
                }
                for (int j = m-1; j >= count; j--) {
                    block[j][i] = stack.pop();
                }
                for (int j = 0; j < count; j++) {
                    block[j][i] = '.';
                }
            }
        }
        return answer;
    }
}