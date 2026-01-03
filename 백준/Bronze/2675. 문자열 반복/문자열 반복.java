import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String[] input = br.readLine().split(" ");
            int count = Integer.parseInt(input[0]);
            String word = input[1];
            String newWord = "";
            for (int j = 0; j < word.length(); j++) {
                for (int k = 0; k < count; k++) {
                    newWord += word.charAt(j);
                }
            }
            System.out.println(newWord);
        }
    }
}
