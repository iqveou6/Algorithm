import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int idx, cost;
		
		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, cost));
			graph.get(b).add(new Node(a, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(1, 0)); //start, cost
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (dist[now.idx] < now.cost) {
				continue;
			}
			
			for(int i = 0; i < graph.get(now.idx).size(); i++) {
				Node next = graph.get(now.idx).get(i);
				
				if (dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		System.out.println(dist[n]);
	}
}
