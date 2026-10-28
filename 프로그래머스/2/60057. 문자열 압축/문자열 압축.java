class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int length = 1; length <= s.length()/2; length++) {
            StringBuilder total = new StringBuilder();
            int count = 1;
            String base = s.substring(0, length);
            for (int i = length; i < s.length(); i+=length) {
                int lastIndex = Math.min(i + length, s.length());
                String temp = s.substring(i, lastIndex);
                if (!base.equals(temp)) {
                    if (count == 1) {
                        total.append(base);
                    } else {
                        total.append(count).append(base);
                    }
                    base = temp;
                    count = 1;
                    continue;
                }
                count++;
            }
            if (count == 1) {
                total.append(base);
            } else {
                total.append(count).append(base);
            }
            answer = Math.min(answer, total.length());
        }
        return answer;
    }
}