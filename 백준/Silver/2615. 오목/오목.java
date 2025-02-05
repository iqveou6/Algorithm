import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[19][19];

        // 보드 입력 받기
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        // 방향: ↗, →, ↘, ↓ (대각선 및 가로/세로)
        int[] dx = {-1, 0, 1, 1};
        int[] dy = {1, 1, 1, 0};

        // 오목 찾기
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue; // 빈칸이면 스킵
                int stone = board[i][j];

                for (int d = 0; d < 4; d++) {
                    int nx = i - dx[d];
                    int ny = j - dy[d];

                    // 반대 방향에 같은 돌이 있으면 시작점이 아님
                    if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == stone) {
                        continue;
                    }

                    int count = 1;
                    nx = i;
                    ny = j;

                    // 해당 방향으로 연속된 돌 개수 카운트
                    while (true) {
                        nx += dx[d];
                        ny += dy[d];

                        if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != stone) {
                            break;
                        }
                        count++;
                    }

                    // 정확히 5개인 경우만 정답
                    if (count == 5) {
                        System.out.println(stone);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        // 승자가 없는 경우
        System.out.println(0);
    }
}
