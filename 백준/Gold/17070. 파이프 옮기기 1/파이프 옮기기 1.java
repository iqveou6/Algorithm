import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n;
	static int answer;
	
	public static void dfs(int x, int y, int dir) {
		if (x >= n || y >= n) return;
		
		if (dir == 2) {
			if (map[x-1][y] == 1) return;
			if (map[x][y-1] == 1) return;
		}
		if (map[x][y] == 1) return;
		
		if (x == n-1 && y == n-1) {
			answer += 1;
			return;
		}
		if (dir == 0) {
			dfs(x, y+1, 0);
			dfs(x+1, y+1, 2);
		} else if (dir == 1) {
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		} else {
			dfs(x, y+1, 0);
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (map[n-1][n-1] == 1) {
			System.out.println(0);
			return;
		}
		dfs(0, 1, 0);
		System.out.println(answer);
	}
}
