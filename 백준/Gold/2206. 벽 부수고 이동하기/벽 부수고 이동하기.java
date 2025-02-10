import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = br.readLine().split(" ");
		int m = Integer.parseInt(mapSize[0]);
		int n = Integer.parseInt(mapSize[1]);
		
		char[][] map = new char[m][n]; 
		int[][][] length = new int[2][m][n];
		
		for(int i = 0; i < m; i++) {
			String input = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][][] visited = new boolean[2][m][n]; //벽 부수는 경우 1
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0, 0});
		length[0][0][0] = 1;

		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			int checked = poll[2];
			if (x==m-1 && y==n-1) break;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 > nx || nx >= m || ny < 0 || ny >= n) {
					continue;
				}
				if (map[nx][ny] == '0') {
					if (!visited[checked][nx][ny]) {
						visited[checked][nx][ny] = true;
						length[checked][nx][ny] = length[checked][x][y] + 1;
						queue.add(new int[]{nx, ny, checked});
					}
				} else {
					if (!visited[1][nx][ny] && checked == 0) {
						visited[1][nx][ny] = true;
						length[1][nx][ny] = length[checked][x][y] + 1;
						queue.add(new int[]{nx, ny, 1});
					}
				}
			}
			
		}
		int answer = Math.max(length[0][m-1][n-1], length[1][m-1][n-1]);
		if (answer == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
