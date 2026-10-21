class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        int[][] grid = new int[m][n];
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            grid[r][c] = i + 1;
        }
        
        int start = 0; int end = drops.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            int[] temp = findSafe(grid, m, n, h, w, mid);
            if (temp[0] == -1) {
                end = mid - 1;
            } else {
                answer[0] = temp[0];
                answer[1] = temp[1];
                start = mid + 1;
            }
        }
        return answer; 
    }
    
    public int[] findSafe(int[][] grid, int m, int n, int h, int w, int k) {
        int[][] pSum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = 0;
                if (grid[i-1][j-1] > 0 && grid[i-1][j-1] <= k) {
                    temp = 1;
                }
                pSum[i][j] = temp + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
            }
        }
        for (int i = 0; i <= m-h; i++) {
            for (int j = 0; j <= n-w; j++) {
                if (pSum[i+h][j+w] - pSum[i+h][j] - pSum[i][j+w] + pSum[i][j] == 0) {
                    return new int[] {i, j};
                }   
            }
        }
        return new int[] {-1, -1};
    }
}