import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] box;
	static int[] dx = {0, 0, 0, 0, -1, 1};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static Queue<int[]> queue = new LinkedList<>();
	static int m;
	static int n;
	static int h;
	static int answer;
	public static void bfs() {	
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] values = queue.poll();
			int height = values[0];
			int x = values[1];
			int y = values[2];
			answer = Math.max(answer, box[height][x][y]);
			cnt++;
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nh = height + dh[i];
				if (0 > nh || nh >= h || 0 > nx || nx >= n || ny < 0 || ny >=m) {
					continue;
				}
				if (box[nh][nx][ny] == 0) {
					box[nh][nx][ny] = box[height][x][y] + 1;
					queue.add(new int[]{nh, nx, ny});
				}
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 0) {
						answer = -1;
						return;
					} 
					answer = Math.max(answer, box[i][j][k]);
				}
			}
		}
		if (answer>0) answer-=1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h+1][n+1][m+1];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 1) {
						queue.add(new int[]{i, j, k});
					}
				}
			}
		}
		bfs();
		System.out.println(answer);
	}
}
