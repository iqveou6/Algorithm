import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp_f = new int[n];
		int[] dp_b = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		Arrays.fill(dp_f, 1);
		Arrays.fill(dp_b, 1);
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) dp_f[i] = Math.max(dp_f[j]+1, dp_f[i]);
			}
		}
		for(int i = n-1; i >= 0; i--) {
			for(int j = i+1; j < n; j++) {
				if (arr[i] > arr[j]) dp_b[i] = Math.max(dp_b[j]+1, dp_b[i]);
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer = Math.max(answer, dp_f[i] + dp_b[i]-1);
		}
		System.out.println(answer);
	}
}
