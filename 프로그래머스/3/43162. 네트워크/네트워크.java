import java.util.*;

class Solution {
    public void dfs(int n, int node, boolean[] visited, int[][] computers) {
        visited[node] = true;
        
        for(int i = 0; i < n; i++) {
            if (node == i) continue;
            if (computers[node][i] == 0) continue;
            if (visited[i] == true) continue;
            dfs(n, i, visited, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
}