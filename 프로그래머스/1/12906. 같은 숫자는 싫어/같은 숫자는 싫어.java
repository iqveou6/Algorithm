import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) {
                answer.add(arr[i-1]);
                num = arr[i];
            }
        }
        if (answer.size() == 0) {
            if (arr.length != 0) answer.add(arr[0]);
        } else {
            if (answer.get(answer.size() - 1) != num) {
            answer.add(num);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}