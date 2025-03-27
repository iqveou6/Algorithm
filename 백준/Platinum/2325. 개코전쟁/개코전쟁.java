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
	static int[] prev;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		distance = new int[n+1];
		prev = new int[n+1];
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Node(y, z));
			graph.get(y).add(new Node(x, z));
		}
		
		dijkstra();
		int answer= 0;
		int start = n;
		while(start!= 1) {
			destroy(start, prev[start]);
			start = prev[start];
			answer = Math.max(answer, distance[n]);
		}
		System.out.println(answer);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.add(new Node(1, 0));
		distance[1] = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			for(Node next : graph.get(current.index)) {
				if(distance[next.index] > distance[current.index] + next.cost) {
					distance[next.index] = distance[current.index] + next.cost;
					pq.add(new Node(next.index, distance[next.index]));
					prev[next.index] = current.index;
				}
			}
		}
	}
	
	public static void destroy(int n1, int n2) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.add(new Node(1, 0));
		distance[1] = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if (current.index == n) return;
			for(Node next : graph.get(current.index)) {
				if(current.index == n1 && next.index == n2 ||
						current.index == n2 && next.index == n1) continue;
				if(distance[next.index] > distance[current.index] + next.cost) {
					distance[next.index] = distance[current.index] + next.cost;
					pq.add(new Node(next.index, distance[next.index]));
				}
			}
		}
	}
	
	
	static class Node {
		int index;
		int cost;
		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}
