

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			String[] arr = x.substring(1, x.length()-1).split(",");
			
			List<String> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(arr[j]);
			}
			
			int reverse = 0;
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			boolean temp = true;
			for(char c : p.toCharArray()) {
				if (c == 'R') {
					reverse += 1;
				} else {
					if (list.size() == 0) {
						temp = false;
						break;
					}
					if (reverse % 2 == 1) {
						list.remove(list.size()-1);
					} else {
						list.remove(0);
					}
				}
			}
			if (temp) {
				if (list.size()!=0) {
					if (reverse %2 == 1) {
						for(int k = list.size()-1; k > 0; k--) {
							sb.append(list.get(k)).append(",");
						}
						sb.append(list.get(0));
					}
					else {
						for(String s : list.subList(0, list.size()-1)) {
							sb.append(s).append(",");
						}
						sb.append(list.get(list.size()-1));
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
			else {
				System.out.println("error");
			}
			
		}
	}
}
