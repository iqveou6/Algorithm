import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] countWords = new int[26];
        for (char c : s.toCharArray()) {
            countWords[c-'a'] ++;
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(countWords[i] + " ");
        }
    }
}
