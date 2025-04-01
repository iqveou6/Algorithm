import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			boolean check = true;
			int n = Integer.parseInt(br.readLine());
			String[] numbers = new String[n];
			for(int j = 0; j < n; j++) {
				numbers[j] = br.readLine();
			}
			Arrays.sort(numbers);
			for(int k = 0; k < n-1; k++) {
				if (numbers[k+1].startsWith(numbers[k])) {
					check = false;
					break;
				}
			}
			if(check) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
