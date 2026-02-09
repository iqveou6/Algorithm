import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                br.readLine();
                if (p.contains("D")) sb.append("error").append('\n');
                else sb.append("[]").append('\n');
                continue;
            }
            String[] num = br.readLine().split(",");
            num[0] = num[0].replace("[", "");
            num[n - 1] = num[n - 1].replace("]", "");
            int flag = 0;
            boolean error = false;
            int left = 0, right = n - 1;
            for (char c : p.toCharArray()) {
                if (left > right) {
                    sb.append("error").append('\n');
                    error = true;
                    break;
                }
                if (c == 'R') {
                    flag += 1;
                } else if (c == 'D') {
                    if (flag % 2 == 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            if (!error) {
                sb.append("[");
                if (flag % 2 == 0) {
                    for (int j = left; j <= right; j++) {
                        if (j == right) sb.append(num[j]);
                        else sb.append(num[j]).append(",");
                    }
                } else {
                    for (int j = right; j >= left; j--) {
                        if (j == left) sb.append(num[j]);
                        else sb.append(num[j]).append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
