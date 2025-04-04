import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int coin : coins) {
			for(int i = coin; i <= k; i++) {
				dp[i] = dp[i-coin] + dp[i];
			}
		}
		System.out.println(dp[k]);
	}
}

