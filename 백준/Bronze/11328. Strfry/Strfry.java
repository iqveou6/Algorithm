import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            char[] na = a.toCharArray();
            char[] nb = b.toCharArray();
            Arrays.sort(na);
            Arrays.sort(nb);
            if (na.length != nb.length) {
                System.out.println("Impossible");
                continue;
            }
            boolean flag = true;
            for (int j = 0 ; j < na.length; j++) {
                if (na[j] != nb[j]) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
