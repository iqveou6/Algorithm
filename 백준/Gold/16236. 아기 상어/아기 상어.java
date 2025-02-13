import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	static int size = 2;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int sx = 0;
		int sy = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					sx = i;
					sy = j;
				}
			}
		}
		
		int eat = 0;
		
		while (true) {
			boolean check = false;
			PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        if (o1[1] == o2[1]) {
                            return o1[2] - o2[2]; 
                        }
                        return o1[1] - o2[1]; 
                    }
                    return o1[0] - o2[0];
                }
			});
			visited = new boolean[n][n];
			queue.add(new int[] {0, sx, sy});
			visited[sx][sy] = true;
			
			while (!queue.isEmpty()) {
				int[] pos = queue.poll();
				int x = pos[1];
				int y = pos[2];
				if (map[x][y] < size && map[x][y] != 0) {
					eat++;
					check = true;
					answer += pos[0];
					sx = x;
					sy = y;
					map[x][y] = 0;
					break;
				}
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 > nx || nx >= n || 0 > ny || ny >= n) {
						continue;
					}
					if(map[nx][ny] <= size && !visited[nx][ny]) {
						queue.add(new int[] {pos[0]+1, nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
			if (!check) break;
			if (eat == size) {
				size++;
				eat = 0;
			}
		}
		System.out.println(answer);
	}
}
