import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int r;
	static int c;
	static int n;
	
	public static int recursive(int r, int c, int m) {
		if (m==1) return 0;
		int half = m/2;
		if (r < half && c < half) {
			return recursive(r, c, half) + half*half*0;
		} else if (r >= half && c < half) {
			return recursive(r-half, c, half) + half*half*2;
		} else if (r < half && c >= half) {
			return recursive(r, c-half, half) + half*half*1;
		} else {
			return recursive(r-half, c-half, half) + half*half*3;
		}
			
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		n = Integer.parseInt(nums[0]);
		r = Integer.parseInt(nums[1]);
		c = Integer.parseInt(nums[2]);
		System.out.println(recursive(r, c, (int)Math.pow(2, n)));
	}
}
