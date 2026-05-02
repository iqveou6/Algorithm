import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int truck : truck_weights) {
            waiting.offer(truck);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int total_weight = 0;
        while (true) {
            if (bridge.isEmpty()) break;
            int finish = bridge.poll();
            total_weight -= finish;
            if (!waiting.isEmpty()) {
                if (total_weight + waiting.peek() > weight) {
                    bridge.offer(0);
                } else {
                    int next = waiting.poll();
                    bridge.offer(next);
                    total_weight += next;
                }
            }
            answer++;
        }
        return answer;
    }
}