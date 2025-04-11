import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Edge{
		int v;
		int w;
		int cost;
		public Edge(int v, int w, int cost) {
			this.v = v;
			this.w = w;
			this.cost = cost;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static long[] dist;
	static ArrayList<Edge> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		dist = new long[n+1];
		Arrays.fill(dist, INF);
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Edge(s, e, c));
		}
		boolean flag = bellmanFord(n, m, 1);
		if(flag) {
			for(int i = 2; i <= n; i++) {
				if(dist[i]==INF)System.out.println(-1);
				else System.out.println(dist[i]);
			}
		}else {
			System.out.println(-1);
		}
	
	}
	public static boolean bellmanFord(int n, int m, int start) {
		dist[start] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Edge node = graph.get(j);
				if(dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost) {
					dist[node.w] = dist[node.v] + node.cost;
				}
			}
		}
		for(int j = 0; j < m; j++) {
			Edge node = graph.get(j);
			if(dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost) {
				return false;
			}
		}
		return true;
	}
}
