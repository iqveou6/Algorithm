import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(a+b-c);
		String aa = String.valueOf(a);
		String bb = String.valueOf(b);
		
		int d = Integer.parseInt(aa.concat(bb));
		System.out.println(d-c);
	}
}
