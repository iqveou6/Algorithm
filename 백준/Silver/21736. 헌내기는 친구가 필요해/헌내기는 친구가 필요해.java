import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int m;
	
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		if (map[x][y] == 'P') answer+=1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 > nx || nx >=n || 0 > ny || ny >= m) {
				continue;
			}
			if (!visited[nx][ny] && map[nx][ny] != 'X') {
				bfs(nx, ny);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		int x = 0; 
		int y = 0;
		
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		bfs(x, y);
		if (answer == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(answer);
	}
}