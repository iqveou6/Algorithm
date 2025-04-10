import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static char[][] map;
	public static int[][] visited;
	public static int r;
	public static int c;
	public static Queue<Node> queue = new LinkedList<>();
	public static Queue<Node> water = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new int[r][c];
		for(int i = 0; i < r; i++) {
			String input = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'S') {
					queue.add(new Node(i, j));
					visited[i][j] = 1;
				}
				if(map[i][j] == '*') {
					water.add(new Node(i, j));
				}
			}
		}
		bfs();
		
	}
	
	public static void bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!queue.isEmpty()) {
			int size = water.size();
			for(int i = 0; i < size; i++) {
				Node curWater = water.poll();
				for(int j = 0; j < 4; j++) {
					int nx = curWater.x + dx[j];
					int ny = curWater.y + dy[j];
					if (0 > nx || nx >= r || 0 > ny || ny >= c) continue;
					if (map[nx][ny] =='.') {
						map[nx][ny] = '*';
						water.add(new Node(nx, ny));
					}
				}
			}
			size = queue.size();
			for(int i = 0; i < size; i++) {
				Node cur = queue.poll();
				for(int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (0 > nx || nx >= r || 0 > ny || ny >= c) continue;
					if (map[nx][ny] == 'D') {
						visited[nx][ny] = visited[cur.x][cur.y] + 1;
						System.out.println(visited[nx][ny]-1);
						return;
					}
					if(map[nx][ny]=='.') {
						map[nx][ny] = 'S';
						visited[nx][ny] = visited[cur.x][cur.y]+1;
						queue.add(new Node(nx, ny));
					}
				}
			}
		}
		System.out.println("KAKTUS");
		return;
	}
	
	public static class Node {
		int x; 
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
