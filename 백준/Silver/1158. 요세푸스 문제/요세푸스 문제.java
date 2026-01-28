import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }


        StringBuilder answer = new StringBuilder("<");
        while(!queue.isEmpty()) {
            for(int i = 1; i < k; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            String next = queue.poll() + "";
            answer.append(next);
            if (!queue.isEmpty()) {
                answer.append(", ");
            }
        }
        answer.append(">");
        System.out.println(answer);

    }
}
