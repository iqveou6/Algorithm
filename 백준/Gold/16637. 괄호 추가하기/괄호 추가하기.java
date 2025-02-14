import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Character> ops;
	static List<Integer> nums;
	static int answer = Integer.MIN_VALUE;
	
	public static void dfs(int index, int result) {
		int res = 0;
		if (index == nums.size()) {
			answer = Math.max(answer, result);
			return;
		}
		dfs(index+1, cul(result, nums.get(index), ops.get(index-1)));
		if (index + 1 < nums.size()) {
			res = cul(nums.get(index), nums.get(index+1), ops.get(index));
			dfs(index + 2, cul(result, res, ops.get(index-1)));
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		ops = new ArrayList<>();
		nums = new ArrayList<>();
		
		for(char c : input.toCharArray()) {
			if (c == '+' || c == '-' || c == '*') {
				ops.add(c);
			}
			else {
				nums.add(Character.getNumericValue(c));
			}
		}
		dfs(1, nums.get(0));
		System.out.println(answer);
	}
	
	public static int cul(int a, int b, char op) {
		if (op == '+') {
			return a+b;
		} else if (op == '-') {
			return a-b;
		} else {
			return a*b;
		}
	}
}
