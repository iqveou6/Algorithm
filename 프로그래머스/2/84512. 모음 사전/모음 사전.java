import java.util.*;

class Solution {
    Set<String> words = new HashSet<>();
    
    public void dfs(String s, char[] alpha, String target) {
        if (s.length() > 5) {
            return;
        }
        if (words.contains(s)) return;
        if (s.length() != 0) {
            words.add(s);
            if (target.equals(s)) return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(s + alpha[i], alpha, target);
        }
        
    }
    public int solution(String word) {
        int answer = 0;
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        dfs("", alpha, word);
        
        List<String> candidate = new ArrayList<>();
        for (String s : words) {
            candidate.add(s);
        }
        Collections.sort(candidate);
        for (int i = 0; i < candidate.size(); i++) {
            if (candidate.get(i).equals(word)) {
                answer = i + 1;
            }
        }
        return answer;
    }
}