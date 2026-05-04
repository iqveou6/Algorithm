import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] temp = new int[j-i+1];
            for (int l = i - 1 ; l < j; l++) {
                temp[l-i+1] = array[l];
            }
            
            Arrays.sort(temp);
            answer.add(temp[k-1]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}