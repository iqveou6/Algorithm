import java.util.*;

class Solution {
    public List<List<Integer>> graph;
    public boolean[] visited;
    public int count = 0;
    public void dfs(int node, int a, int b) {
        for (Integer next : graph.get(node)) {
            if (!visited[next] && !((a == node && b == next) || (a == next && b == node))) {
                visited[next] = true;
                count++;
                dfs(next, a, b);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] value : wires) {
            graph.get(value[0]).add(value[1]);
            graph.get(value[1]).add(value[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            visited = new boolean[n+1];
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    count++;
                    visited[j] = true;
                    dfs(j, a, b);
                    int left = count;
                    int right = n - count;
                    answer = Math.min(Math.abs(left - right), answer);
                    count = 0;
                } 
            }
        }
        return answer;
    }
}