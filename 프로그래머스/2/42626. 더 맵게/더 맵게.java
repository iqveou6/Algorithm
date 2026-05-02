import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.offer(sco);
        }
        
        while (!pq.isEmpty()) {
            int sco1 = pq.poll();
            if (sco1 >= K) break;
            if (pq.isEmpty()) {
                return -1;
            }
            int sco2 = pq.poll();
            pq.offer(sco1 + sco2 * 2);
            answer++;
        }
        return answer;
    }
}