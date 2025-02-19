import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int maxScore = 0;
	static int minScore = Integer.MAX_VALUE;
	static int[] dy = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][3];
		visited = new boolean[n][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] maxDp = new int[n][3];
		int[][] minDp = new int[n][3];
		
		maxDp[0][0] = board[0][0];
		maxDp[0][1] = board[0][1];
		maxDp[0][2] = board[0][2];
		
		minDp[0][0] = board[0][0];
		minDp[0][1] = board[0][1];
		minDp[0][2] = board[0][2];
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				minDp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				for(int pos = 0; pos < 3; pos++) {
					if (j + dy[pos] >= 3 || j + dy[pos] < 0) continue;
					maxDp[i][j] = Math.max(maxDp[i-1][j+dy[pos]] + board[i][j], maxDp[i][j]);
					minDp[i][j] = Math.min(minDp[i-1][j+dy[pos]] + board[i][j], minDp[i][j]);
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			maxScore = Math.max(maxDp[n-1][i], maxScore);
			minScore = Math.min(minDp[n-1][i], minScore);
		}
		System.out.println(maxScore + " " + minScore);
	}
}
