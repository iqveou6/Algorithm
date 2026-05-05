import java.util.*;

class Solution {
    public boolean[] visited;
    public StringBuilder number = new StringBuilder();
    public Set<Integer> candidate = new HashSet<>();
    public void dfs(char[] numArr) {
        if (number.length() != 0) {
            candidate.add(Integer.parseInt(number.toString()));
        }
        for (int i = 0; i < numArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                number.append(numArr[i]);
                dfs(numArr);
                visited[i] = false;
                number.deleteCharAt(number.length() - 1);
            }
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        char[] numArr = new char[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            numArr[i] = numbers.charAt(i);
        }
        visited = new boolean[numbers.length()];
        dfs(numArr);
        
        for (int num : candidate) {
            boolean flag = true;
            if (num <= 1) flag = false;
            else if (num <= 3) flag = true;
            else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}