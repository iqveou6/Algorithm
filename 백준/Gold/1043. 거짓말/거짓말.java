import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static List<Integer> know;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		parent = new int[n+1];
		for(int i = 1; i <=n; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if (num==0) {
			System.out.println(m);
			return;
		}
		know = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			int index = Integer.parseInt(st.nextToken());
			know.add(index);
		}
		
		for(int i = 0; i < know.size()-1; i++) {
			union(know.get(i), know.get(i+1));
		}
		List<List<Integer>> party = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			party.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			int[] temp = new int[num];
			for(int j = 0; j < num; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
				party.get(i).add(temp[j]);
			}
			for(int j = 1; j < num; j++) {
				union(temp[0], temp[j]);
			
			}
		}
		int answer = 0;
		for(int i = 0; i < m; i++) {
			boolean check = false;
			for(int nxt : party.get(i)) {
				if (know.contains(find(parent[nxt]))) {
					check = true;
					break;
				}
			}
			if (!check) answer++;
		}
		System.out.println(answer);
	}
	
	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if (know.contains(ny)) {
			int temp = ny;
			ny = nx;
			nx = temp;
		}
		parent[ny] = nx;
	}
	static int find(int x) {
		if (parent[x] == x) return x;
		return find(parent[x]);
	}
}
