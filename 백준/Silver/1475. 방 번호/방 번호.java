import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cards = new int[10];
        String n = br.readLine();

        for(int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '9') {
                cards[6]++;
                continue;
            }
            cards[n.charAt(i) - '0']++;
        }

        if (cards[6] % 2 == 0) cards[6] = cards[6] / 2;
        else cards[6] = cards[6] / 2 + 1;

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if (cards[i] > answer) answer = cards[i];
        }
        System.out.println(answer);
    }
}
