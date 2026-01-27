import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        int lt = 0;
        int rt = n - 1;
        Arrays.sort(arr);
        while (lt < rt) {
            int a = arr[lt];
            int b = arr[rt];
            if (a + b == x) {
                lt++;
                rt--;
                answer++;
            }
            else if (a + b < x) lt++;
            else rt--;
        }
        System.out.println(answer);
    }
}
