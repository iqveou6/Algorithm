import java.util.*;

class Solution {
    public boolean[] visited;
    public int answer;
    public void dfs(int k, int depth, int[][] dungeons) {
        answer = Math.max(depth, answer);
        if (depth >= dungeons.length) {
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], depth + 1, dungeons);
                visited[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }
}