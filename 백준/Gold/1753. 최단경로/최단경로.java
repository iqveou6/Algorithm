import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Node>> graph;
	static int[] distance;
	static boolean[] visited;
	static class Node {
		int index;
		int cost;
		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		graph = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		distance = new int[v+1];
		visited = new boolean[v+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, cost));
		}
		dijkstra(start);
		for(int i = 1; i <= v; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.index]) continue;
			visited[current.index] = true;
			for(int i = 0; i < graph.get(current.index).size(); i++) {
				Node next = graph.get(current.index).get(i);
				if(!visited[next.index] && distance[next.index] > distance[current.index]+next.cost) {
					distance[next.index] = Math.min(distance[current.index]+next.cost, distance[next.index]);
					pq.add(new Node(next.index, distance[next.index]));
				}
			}
		}
	}
}
