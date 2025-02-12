import java.util.Scanner;

public class Main {
	static int[] nqueen;
	static int n;
	static int answer;
	
	public static void dfs(int x, int y) {
		if (x == n-1) {
			answer+=1;
			return;
		}
		for(int i = 0; i < n; i++) {
			if (check(x+1, i)) {
				nqueen[x+1] = i;
				dfs(x+1, i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		nqueen = new int[n];
		
		for(int i = 0; i < n; i++) {
			nqueen[0] = i;
			dfs(0, i);
		}
		System.out.println(answer);
		sc.close();
	}
	
	public static boolean check(int x, int y) {
		for(int i = 0; i < x; i++) {
			if (Math.abs(nqueen[i] - y) == Math.abs(i - x) || nqueen[i] + i == x + y) {
				return false;
			}
			if (y == nqueen[i]) {
				return false;
			}
		}
		return true;
	}
}
