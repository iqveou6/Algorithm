import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static List<List<Integer>> graph;
	public static int[] plan;
	public static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				if (Integer.parseInt(st.nextToken())==1) {
					union(i, j);
				}
			}
		}
		plan = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		boolean check = true;
		for(int i = 0; i < m-1; i ++) {
			if(find(plan[i]) != find(plan[i+1])) {
				check = false;
				break;
			}
		}
		System.out.println(check ? "YES" : "NO");
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
}
