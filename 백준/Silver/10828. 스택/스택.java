import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int index = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int x ;
            if (commend.equals("push")) {
                x = Integer.parseInt(st.nextToken());
                stack[index++] = x;
            } else if (commend.equals("pop")) {
                if (index == 0) System.out.println(-1);
                else {
                    System.out.println(stack[index - 1]);
                    index--;
                }
            } else if (commend.equals("size")) {
                System.out.println(index);
            } else if (commend.equals("empty")) {
                if (index == 0) System.out.println(1);
                else System.out.println(0);
            } else if (commend.equals("top")) {
                if (index == 0) System.out.println(-1);
                else System.out.println(stack[index - 1]);
            }
        }
    }
}
