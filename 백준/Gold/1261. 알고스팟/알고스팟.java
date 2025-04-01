import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int n;
	static int m;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.add(new Node(0, 0, 0));
		visited[0][0] = true;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.x == n-1 && now.y == m-1) {
				System.out.println(now.cost);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;
				if(visited[nx][ny]) continue;
				if (graph[nx][ny] == 1) {
					pq.add(new Node(nx, ny, now.cost+1));
				} else {
					pq.add(new Node(nx, ny, now.cost));
				}
				visited[nx][ny] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);
		
		graph = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = temp.charAt(j)-'0';
			}	
		}
		bfs();
	}
	
	public static class Node {
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}