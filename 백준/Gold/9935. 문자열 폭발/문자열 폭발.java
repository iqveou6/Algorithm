import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(char c : string.toCharArray()) {
			stack.add(c);
			if(stack.size() >= bomb.length()) {
				boolean check = true;
				for(int i = 0; i <bomb.length(); i++) {
					if (stack.get(stack.size()-bomb.length()+i) != bomb.charAt(i)) {
						check = false;
					}
				}
				if(check) {
					for(int i = 0; i < bomb.length(); i++) {
						stack.pop();
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else System.out.println(sb.toString());
	}
}
