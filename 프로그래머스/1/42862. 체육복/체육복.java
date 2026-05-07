import java.util.*;

class Solution {
    public int[] student;
    public int answer = 0;
    public void dfs(int[] student, int[] lost) {
        int temp = 0;
        for (int i = 1; i < student.length - 1 ; i++) {
           if (student[i] >= 1) temp++; 
        }
        answer = Math.max(answer, temp);
        
        for (int i : lost) {
            if (student[i] == 1) continue;
            if (student[i - 1] == 2) {
                student[i] = 1;
                student[i - 1] = 1;
                dfs(student, lost);
                student[i - 1] = 2;
                student[i] = 0;
            }
            if (student[i + 1] == 2) {
                student[i] = 1;
                student[i + 1] = 1;
                dfs(student, lost);
                student[i + 1] = 2;
                student[i] = 0;
            }
        }
    }
    public int solution(int n, int[] lost, int[] reserve) {
        student = new int[n+2];
        for (int i = 1; i <= n; i++) {
            student[i] = 1;    
        }
        
        for (int i : lost) {
            student[i] -= 1;
        }
        for (int i : reserve) {
            student[i] += 1;
        }
        dfs(student, lost);
        return answer;
    }
}