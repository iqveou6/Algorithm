import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Node>> graph = new ArrayList<>();
	static int[] distance;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, time));
		}
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			answer = Math.max(dijkstra(i, x)+dijkstra(x, i), answer);
		}
		System.out.println(answer);
	}
	public static int dijkstra(int start, int end) {
		distance = new int[n+1];
		visited = new boolean[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(current.index == end) return current.cost;
			if (visited[current.index]) continue;
			visited[current.index] = true;
			for(int i = 0; i < graph.get(current.index).size(); i++) {
				Node next = graph.get(current.index).get(i);
				if(!visited[next.index] && distance[next.index] > distance[current.index]+next.cost) {
					distance[next.index] = distance[current.index]+next.cost;
					pq.add(new Node(next.index, distance[next.index]));
				}
			}
		}
		return distance[end];
	}
	static class Node{
		int index;
		int cost;
		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}
