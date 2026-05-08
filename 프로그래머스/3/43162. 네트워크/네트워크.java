import java.util.*; 

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public void dfs(int i, boolean[] visited) {
        for (int next : graph.get(i)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited);
                answer++;
            }
        }
        return answer;
    }
}