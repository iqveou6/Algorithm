import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] tall = new ArrayList[n+1];
		List<Integer>[] small = new ArrayList[n+1];
		int answer = 0;
		for(int i = 0; i < n+1; i++) {
			tall[i] = new ArrayList<>();
			small[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tall[a].add(b);
			small[b].add(a);
		}
			
		Queue<Integer> queue = new LinkedList<>();
		for(int student = 1; student <= n; student++) {
			queue.add(student);
			boolean[] visited = new boolean[n+1];
			visited[student] = true;
			int cnt = 1;
			while(!queue.isEmpty()) {
				int q = queue.poll();
				for(int i = 0; i < tall[q].size(); i++) {
					int next = tall[q].get(i);
					if (!visited[next]) {
						queue.add(next);
						visited[next] = true;
						cnt++;
					}
				}
			}
			visited = new boolean[n+1];
			visited[student] = true;
			queue = new LinkedList<>();
			queue.add(student);
			while(!queue.isEmpty()) {
				int q = queue.poll();
				for(int i = 0; i < small[q].size(); i++) {
					int next = small[q].get(i);
					if (!visited[next]) {
						queue.add(next);
						visited[next] = true;
						cnt++;
					}
				}
			}
			if (cnt == n) {
				answer++;
			}
		} 
		System.out.println(answer);
	}
}

