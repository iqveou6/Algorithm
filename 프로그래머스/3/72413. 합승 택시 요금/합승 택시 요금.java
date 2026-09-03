import java.util.*;

class Node {
    int idx;
    int cost;
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] distS = dijkstra(s, graph, n);
        int[] distA = dijkstra(a, graph, n);
        int[] distB = dijkstra(b, graph, n);
        
        for (int i = 1; i <= n; i++) {
            if (i != s || i != a || i != b) {
                answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
            }
        }
        return answer;
    }
    
    public int[] dijkstra(int s, List<List<Node>> graph, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.idx] < cur.cost) {
                continue;
            }
            
            for(Node next : graph.get(cur.idx)) {
                if (dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }
}