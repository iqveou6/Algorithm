class Solution {
    public Boolean checkCorrect(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return true;
    }
    
    public int cutString(String s) {
        int count = 0;
        int index = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count==0) {
                return i;
            }
        }
        return 0;
    }
    
    
    
    public String solution(String p) {
        String answer = "";
        if (p.equals("")) return p;
        int index = cutString(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);
        
        if (checkCorrect(u)) {
            answer = u + solution(v);
        } else {
            System.out.println(u);
            answer = "(" + solution(v) + ")";
            for (int i = 1; i < u.length()-1; i++) {
                if (u.charAt(i) == '(') answer += ')';
                else answer += '(';
            }
        }
        return answer;
    }
}