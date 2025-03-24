import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			 
			int cul = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cul == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
	}
	
	public static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if (nx < ny) {
			parent[ny] = nx;
		} else {
			parent[nx] = ny;
		}
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}
