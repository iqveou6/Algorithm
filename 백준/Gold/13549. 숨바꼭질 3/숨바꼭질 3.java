import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static int n;
	static int k;
	public static class Info{
		int x;
		int time;
		Info(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	public static int bfs(int x, int time) {
		Queue<Info> queue = new LinkedList<>();
		int answer = 100000;
		queue.add(new Info(x, 0));
		visited[x] = true;
		while(!queue.isEmpty()) {
			Info now = queue.poll();
			if (now.x == k) {
				return now.time;
			}
            if (now.x*2 <= 100000 && !visited[now.x*2]) {
				queue.add(new Info(now.x*2, now.time));
				visited[now.x*2] = true;
			}
			int[] arr = new int[] {now.x-1, now.x+1};
			for(int next: arr) {
				if (0 <= next && next <= 100000 && !visited[next]) {
					queue.add(new Info(next, now.time+1));
					visited[next] = true;
				} 
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		visited = new boolean[100001];
		System.out.println(bfs(n, 0));
		sc.close();
	}
}
