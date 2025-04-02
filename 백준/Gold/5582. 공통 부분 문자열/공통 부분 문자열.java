import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int r = s1.length();
		int c = s2.length();
		int[][] dp = new int[r+1][c+1];
		int answer = 0;
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					answer = Math.max(dp[i][j], answer);
				}
			}
		}
		System.out.println(answer);
	}
}
