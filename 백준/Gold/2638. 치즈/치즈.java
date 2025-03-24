import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n; static int m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Pos {
		int x; 
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x, y));
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static boolean melt(int x, int y) {
		int cnt = 0;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
			if (map[nx][ny] == 0 && visited[nx][ny]) cnt++;
		}
		if (cnt >= 2) return true;
		return false;
	}
	
	public static boolean checkAll() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			if (map[i][0] == 0 && !visited[i][0]) bfs(i, 0);
			if (map[i][m-1] == 0 && !visited[i][m-1]) bfs(i, m-1);
		}
		
		for(int i = 0; i < m; i++) {
			if (map[0][i] == 0 && !visited[0][i]) bfs(0, i);
			if (map[n-1][i] == 0 && !visited[n-1][i]) bfs(n-1, i);
		}
		int answer = 0;
		while(!checkAll()) {
			visited = new boolean[n][m];
			for(int i = 0; i < n; i++) {
				if (map[i][0] == 0 && !visited[i][0]) bfs(i, 0);
				if (map[i][m-1] == 0 && !visited[i][m-1]) bfs(i, m-1);
			}
			
			for(int i = 0; i < m; i++) {
				if (map[0][i] == 0 && !visited[0][i]) bfs(0, i);
				if (map[n-1][i] == 0 && !visited[n-1][i]) bfs(n-1, i);
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if (map[i][j] == 1 && melt(i, j)) {
							map[i][j] = 0;
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}
