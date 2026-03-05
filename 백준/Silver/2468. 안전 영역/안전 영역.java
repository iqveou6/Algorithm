import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] area;
    static boolean[][] checked;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    
    public static void bfs(int x, int y, int al) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        checked[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            x = q[0];
            y = q[1];
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!checked[nx][ny] && area[nx][ny] > al) {
                    queue.add(new int[] {nx, ny});
                    checked[nx][ny] = true;
                }
            }
        }
     }
    public static void main(String[] args) throws Exception{
        //--------------솔루션 코드를 작성하세요.--------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(area[i][j], max);
            }
        }
        
        int answer = 0;
        for(int al = 0; al <= max; al++) {
            checked = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] > al && !checked[i][j]) {
                        checked[i][j] = true;
                        bfs(i, j, al);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

}