import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] info;
	static int answer;
	static int n;
	static int l;
	
	static void dfs(int depth, int score, int cal) {
		if (l >= cal) answer = Math.max(answer, score);
		if (n == depth) {
			return;
		}

		dfs(depth+1, score + info[depth][0], cal + info[depth][1]);
		dfs(depth+1, score, cal);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			info = new int[n][2];
			answer = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					info[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
