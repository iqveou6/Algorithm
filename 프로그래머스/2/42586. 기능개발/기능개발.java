import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0;i<progresses.length;i++) {
            int remainingWork = 100-progresses[i];
            if (remainingWork%speeds[i] == 0) {
                queue.add(remainingWork/speeds[i]);
            } else {
                queue.add(remainingWork/speeds[i] + 1);
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int finishDay = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int currentDay = queue.poll();
            if (finishDay >= currentDay) {
                count++;
            } else {
                finishDay = currentDay;
                arr.add(count);
                count = 1;
            }
        }
        arr.add(count);
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i); 
        }
        return answer;
    }
}