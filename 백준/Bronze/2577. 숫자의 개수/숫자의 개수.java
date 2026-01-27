import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String mul = String.valueOf(a*b*c);

        for(char n : mul.toCharArray()) {
            numbers[n - '0']++;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(numbers[i]);
        }
    }
}
