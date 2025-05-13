import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        if (cacheSize == 0) return cities.length * 5;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (!cache.contains(city)) {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                answer += 5;
                cache.add(city);
            }
            else {
                answer += 1;
                cache.remove(city);
                cache.addLast(city);
            }
        }
        return answer;
    }
}