import java.util.*;

class Solution {
    public List<List<int[]>> pipe = new ArrayList<>();
    public int answer = 0;
    public int solution(int n, int infection, int[][] edges, int k) {
        boolean[] infect = new boolean[n+1];
        infect[infection] = true;

        for (int i = 0; i <= 3; i++) {
            pipe.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            pipe.get(edge[2]).add(new int[] {edge[0], edge[1]});
        }
        dfs(infect, 0, k);
        return answer;
    }
    
    public void dfs(boolean[] infect, int count, int k) {
        if (count == k) {
            int temp = 0;
            for (int i = 1; i < infect.length; i++) {
                if (infect[i]) temp++;
            }
            answer = Math.max(answer, temp);
            return;
        }
        
        for (int type = 1; type <= 3; type++) {
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i < infect.length; i++) {
                if (infect[i]) {
                    queue.offer(i);
                }
            }
            boolean[] nextInfect = infect.clone();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int[] edges : pipe.get(type)) {
                    int next = 0;
                    if (edges[0] == cur && !nextInfect[edges[1]]) {
                        next = edges[1];
                    }
                    if (edges[1] == cur && !nextInfect[edges[0]]) {
                        next = edges[0];
                    }
                    if (next != 0) {
                        nextInfect[next] = true;
                        queue.offer(next);
                    }
                }
            }
            dfs(nextInfect, count+1, k);
        }
        
    }
}