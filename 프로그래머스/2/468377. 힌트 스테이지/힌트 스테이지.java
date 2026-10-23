class Solution {
    public static int[][] cost;
    public static int[][] hint;
    public static int answer;
    public int solution(int[][] cost, int[][] hint) {
        answer = 0;
        this.cost = cost;
        this.hint = hint;
        int[] count = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            answer += cost[i][0];
        }
        dfs(0, 0, count);
        return answer;
    }
    
    public void dfs(int stage, int totalCost, int[] count) {
        if (totalCost > answer) {
           return;
        }
        if (stage == cost.length) {
            answer = Math.min(answer, totalCost);
            return;
        }
        
        int useHint = count[stage];
        if (useHint >= cost.length) {
            useHint = cost.length - 1;
        }
        dfs(stage + 1, totalCost + cost[stage][useHint], count);
        if (stage == cost.length - 1) return;
        int hintCost = hint[stage][0];
        for (int i = 1; i < hint[stage].length; i++) {
            count[hint[stage][i]-1]++;
        }
        dfs(stage + 1, totalCost + hintCost + cost[stage][useHint], count);
        for (int i = 1; i < hint[stage].length; i++) {
            count[hint[stage][i]-1]--;
        }
    }
}