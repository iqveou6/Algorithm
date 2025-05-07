class Solution {
    public String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if (s.contains(number[i])) {
                s = s.replace(number[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }
}