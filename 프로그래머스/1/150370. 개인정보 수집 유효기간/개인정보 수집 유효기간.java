import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
         
        for(int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            int l = Integer.parseInt(map.get(privacies[i].split(" ")[1]))*28;
            
            int left = (year - Integer.parseInt(date.split("\\.")[0]))*28*12+
                (month-Integer.parseInt(date.split("\\.")[1]))*28+
                (day-Integer.parseInt(date.split("\\.")[2]));
            
            if(left >= l) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}