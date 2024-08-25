import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int bfs(int[][] box, Queue<int[]> queue) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x;
        int y;
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            answer = tomato[2];
            for (int i = 0; i < 4; i++) {
                x = tomato[0] + dx[i];
                y = tomato[1] + dy[i];
                if (x < 0 || x >= box.length || y < 0 || y >= box[0].length) {
                    continue;
                }
                if (box[x][y] == 0) {
                    box[x][y] = 1;
                    queue.offer(new int[] {x, y, tomato[2] + 1});
                }
            }
        }

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M]; //토마토 보관 창고
        Queue<int[]> queue = new LinkedList<>(); 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new int[]{i, j, 0}); //익은 토마토의 위치와 최소 일수를 담아 queue에 저장
                }
            }
        }

        int answer = bfs(box, queue);
        System.out.println(answer);
    }



}

