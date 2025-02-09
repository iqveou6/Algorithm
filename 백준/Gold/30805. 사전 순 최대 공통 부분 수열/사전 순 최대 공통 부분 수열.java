import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx_a = 0;
		int idx_b = 0;
		List<Integer> answer = new ArrayList<>();
		while (true) {
			if (idx_a >= n && idx_b >= m) break;
			int max = 0;
			for (int i = idx_a; i < n; i++) {
				for (int j = idx_b; j <m; j++) {
					if (a[i] == b[j]) {
						if (max < a[i]) {
							max = a[i];
						}
					}
				}
			}
			if (max!= 0) {
				while(a[idx_a] != max) idx_a++;
				while(b[idx_b] != max) idx_b++;
				
				answer.add(max);
			}
			
			idx_a++;
			idx_b++;
		}
		System.out.println(answer.size());
		for(Integer i : answer) {
			System.out.print(i + " ");
		}
		
	}
}