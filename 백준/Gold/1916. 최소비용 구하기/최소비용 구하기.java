import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int idx;
		int cost;
		
		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] dist = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));
		
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (dist[now.idx] < now.cost) {
				continue;
			}
			
			for(int i = 0; i < graph.get(now.idx).size(); i++) {
				Node next = graph.get(now.idx).get(i);
				
				if (dist[next.idx] > next.cost + now.cost) {
					dist[next.idx] = next.cost + now.cost;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		System.out.println(dist[end]);
	}
}
