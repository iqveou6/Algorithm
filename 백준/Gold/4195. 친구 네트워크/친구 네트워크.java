import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static int[] parent;
	public static int[] size;
	public static HashMap<String, Integer> friend;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; tc++) {
			int f = Integer.parseInt(br.readLine());
			friend = new HashMap<String, Integer>();
			parent = new int[f*2+1];
			size = new int[f*2+1];
			for(int i = 1; i <= f*2; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			int index = 1;
			for(int i = 1; i <= f; i++) {
				String[] input = br.readLine().split(" ");
				if (!friend.containsKey(input[0])) {
					friend.put(input[0], index);
					index++;
				} 
				if (!friend.containsKey(input[1])) {
					friend.put(input[1], index);
					index++;
				}
				int x = friend.get(input[0]);
				int y = friend.get(input[1]);
				System.out.println(union(x, y));
			}
		
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int union(int x, int y){
		x = find(x);
		y = find(y);
		if (x != y) {
			size[x] += size[y];
			parent[y] = x;
		}
		return size[x];
	}
	
	public static int find(int x){
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}