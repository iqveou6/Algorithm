import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0]; 
            return a[2] - b[2];
        });
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int curTime = 0;
        int i = 0;
        while (i < jobs.length || !pq.isEmpty()) {
            while (i < jobs.length && curTime >= jobs[i][0]) {
                pq.offer(new int[] {jobs[i][0], jobs[i][1], i});
                i++;
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                curTime += cur[1];
                answer += curTime - cur[0];
            } else {
                curTime = jobs[i][0];
            }
        }
        
        return answer/jobs.length;
    }
}