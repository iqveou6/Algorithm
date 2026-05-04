import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] data = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            data[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(data, (a, b) -> (b + a).compareTo(a + b));
        for (int i = 0; i < data.length; i++) {
            answer.append(data[i]);
        }
        String result = answer.toString();
        if (result.startsWith("0")) {
            return "0";
        }
        return answer.toString();
    }
}