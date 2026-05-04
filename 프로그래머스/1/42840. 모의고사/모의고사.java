import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[4];
        
        for (int i = 0; i < answers.length; i++) {
            if (one[i%5] == answers[i]) {
                count[1]++;
            } 
            if (two[i%8] == answers[i]) {
                count[2]++;
            }
            if (three[i%10] == answers[i]) {
                count[3]++;
            }
        }
        
        int max = 0;
        for (int i = 1; i <= 3; i++) {
            max = Math.max(count[i], max);
        }
        
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            if (max == count[i]) result.add(i);
        }
        
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}