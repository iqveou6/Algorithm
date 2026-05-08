import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int in = routes[0][0];
        int out = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (out >= routes[i][0]) {
                in = routes[i][0];
                out = Math.min(out, routes[i][1]);
            } else {
                answer++;
                in = routes[i][0];
                out = routes[i][1];
            }
        }
        return answer + 1;
    }
}