import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minValue = 0; 
        int maxValue = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
            maxValue = Math.max(sizes[i][0], maxValue);
            minValue = Math.max(sizes[i][1], minValue);
        }
        return maxValue * minValue;
    }
}