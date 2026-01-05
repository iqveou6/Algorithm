import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            String s = br.readLine();
            boolean group = true;
            boolean[] check = new boolean[26];
            for (int i = 1; i < s.length(); i++) {
                char a = s.charAt(i - 1);
                char b = s.charAt(i);
                if (i == s.length() - 1) {
                    if (check[b - 'a']) {
                        group = false;
                        break;
                    }
                }
                if (check[a - 'a']) {
                    group = false;
                    break;
                }
                if (!check[a - 'a'] && a != b) {
                    check[a - 'a'] = true;
                }
            }
            if (group) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
