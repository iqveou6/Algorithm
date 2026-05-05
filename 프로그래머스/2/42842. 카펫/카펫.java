import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int row = yellow / i;
                int col = i;
                if (row < col) break;
                int total = (row + 2) * (col + 2);
                if (yellow + brown == total) {
                    answer[0] = row + 2;
                    answer[1] = col + 2;
                }
            }
        }
        return answer;
    }
}