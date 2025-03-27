import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int n; static int k;
	static int[] time;
	static int minTime = Integer.MAX_VALUE;
	static int cnt;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
        if(n==k) {
			minTime = 0;
			cnt = 1;
		}
		time = new int[100001];
		bfs(n);
		System.out.println(minTime);
		System.out.println(cnt);
		sc.close();
	}
	
	public static void bfs(int position) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(position);
		time[position] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(time[now] > minTime) {
				return;
			}
			if (now != 0) {
				int[] nextPos = {now-1, now+1, now*2};
				for(int next : nextPos) {
					if (next < 0 || next >100000) continue;
					if(next == k) {
						minTime = time[now];
						cnt++;
					}
					if (time[next] == 0 || time[next] == time[now]+1) {
						time[next] = time[now] + 1;
						q.add(next);
					}
				}
			} else {
				int next = now + 1;
				if(next == k) {
					minTime = time[now];
					cnt++;
				}
				if (time[next] == 0 || time[next] == time[now]+1) {
					time[next] = time[now] + 1;
					q.add(next);
				}
			}
		}
	}
	
	
}
