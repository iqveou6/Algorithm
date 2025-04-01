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
	static int INF = 200000*1000+1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		distance = new int[n+1];
		Arrays.fill(distance, INF);
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		dijkstra(1);
		int stov1 = distance[v1];
		int stov2 = distance[v2];
		
		dijkstra(v1);
		int v1tov2 = distance[v2];
		int v1ton = distance[n];
		
		dijkstra(v2);
		int v2tov1 = distance[v1];
		int v2ton = distance[n];
		int answer = 0;
		int answer1 = stov1+v1tov2+v2ton;
		int answer2 = stov2+v2tov1+v1ton;
		if(answer1 >= INF && answer2 >= INF) answer = -1;
		else {
			answer = Math.min(answer1, answer2);
		}
		System.out.println(answer);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		Arrays.fill(distance, INF);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for(int i = 0; i < graph.get(node.index).size(); i++) {
				Node next = graph.get(node.index).get(i);
				if(distance[next.index] > distance[node.index] + next.cost) {
					distance[next.index] = distance[node.index] + next.cost; 
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
