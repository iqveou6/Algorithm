import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	static char[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int m;
	static int max;
	static boolean[] alpha;
	
	public static void dfs(int x, int y, int length) {
		alpha[board[x][y]-'A'] = true;
		max = Math.max(length, max);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 > nx || nx >= n || 0 > ny || ny >= m) {
				continue;
			}
			if (alpha[board[nx][ny]-'A'] == false) {
				dfs(nx, ny, length+1);
				alpha[board[nx][ny]-'A'] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		
		alpha = new boolean[26];
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		
		board = new char[n][m];
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		dfs(0, 0, 0);
		System.out.println(max+1);
	}
}
