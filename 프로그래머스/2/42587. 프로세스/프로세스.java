import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] level = new int[11];
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
            level[priorities[i]]++;
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean check = true;
            for (int i = 10; i > cur[0]; i--) {
                if (level[i] != 0) {
                    queue.offer(cur);
                    check = false;
                    break;
                }
            }
            if (check) {
                level[cur[0]]--;
                answer++;
                if (location == cur[1]) {
                    return answer;
                } 
            }
        }
        return answer;
    }
}