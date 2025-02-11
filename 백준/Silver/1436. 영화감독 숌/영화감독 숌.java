import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] title = new int[10001];
		int num = 666;
		for (int i = 1; i < 10001; i++) {
			while(!(num + "").contains("666")) {
				num+=1;
			}
			title[i] = num;
			num+=1;
		}
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		System.out.println(title[n]);
	}
}
