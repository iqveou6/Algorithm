
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static List<List<Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[101];
			int[] distance = new int[101];
			graph = new ArrayList<>();
			for(int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<Integer>());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < length/2; i++) {
				int from =  Integer.parseInt(st.nextToken());
				int to =  Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(start);
			visited[start] = true;
			while (!queue.isEmpty()) {
				int v = queue.poll();
				for(int i = 0; i < graph.get(v).size(); i++) {
					int next = graph.get(v).get(i);
					if (!visited[next]) {
						visited[next] = true;
						queue.add(next);
						distance[next] = distance[v] + 1;
					}
				}
			}
			int maxDistance = 0;
			int answer = 0;
			for(int i = 1; i <= 100; i++) {
				if (maxDistance <= distance[i]) {
					maxDistance = distance[i];
					answer = i;
				}
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
