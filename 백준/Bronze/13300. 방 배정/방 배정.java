import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //총 학생 수
        int k = Integer.parseInt(st.nextToken()); // 방 최대인원
        int[][] students = new int[7][2]; //학년, 성별
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            students[y][s]++;
        }
        int answer = 0;
        for (int i = 1; i < 7; i++) {
            int g = students[i][0];
            int b = students[i][1];
            if (g != 0) {
                if (g % k == 0) answer = answer + g / k;
                else answer = answer + g / k + 1;
            }
            if (b != 0) {
                if (b % k == 0) answer = answer + b / k;
                else answer = answer + b / k + 1;
            }
        }
        System.out.println(answer);
    }
}
