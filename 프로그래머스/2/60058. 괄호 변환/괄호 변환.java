import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.equals("")) return "";
        Deque<Character> stack = new ArrayDeque<>();
        String u = "";
        String v = "";
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                count--;
            } else count++;
            if (count == 0) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (isRight(u)) {
            return sb.append(u).append(solution(v)).toString();
        } else {
            sb.append("(").append(solution(v)).append(")");
            u = u.substring(1, u.length()-1);
            for (char c : u.toCharArray()) {
                if (c == '(') {
                    sb.append(")");
                } else sb.append("(");
            }
        }
        return sb.toString();
    }
    
    public boolean isRight(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else count--;
            if (count < 0) return false;
        }
        if (count != 0) return false;
        return true;
    }
}