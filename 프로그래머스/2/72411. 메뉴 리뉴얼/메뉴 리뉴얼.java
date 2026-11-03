import java.util.*;

class Solution {
    public Map<Character, List<Integer>> map = new HashMap<>();
    public char[] menu;
    public List<String> selectedMenu;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                if (!map.containsKey(orders[i].charAt(j))) {
                    map.put(orders[i].charAt(j), new ArrayList<>());
                }
                map.get(orders[i].charAt(j)).add(i+1);
            }
        }
        menu = new char[map.size()];
        int index = 0;
        for (char order : map.keySet()) {
            menu[index++] = order;
        }
        for (int c : course) {
            selectedMenu = new ArrayList<>();
            int maxVal = 0;
            dfs(0, 0, c, "");
            int[] find;
            List<String> result = new ArrayList<>();
            for (String menu : selectedMenu) {
                find = new int[orders.length + 1];
                for (char m : menu.toCharArray()) {
                    for (int i : map.get(m)) {
                        find[i]++;
                    }
                }
                int temp = 0;
                for (int j = 0; j < find.length; j++) {
                    if (find[j] >= c) {
                        temp++;
                    }
                }
                if (temp >= 2) {
                    if (temp > maxVal) {
                        result.clear();
                        maxVal = temp;
                        result.add(menu);
                    } else if (temp == maxVal) {
                        result.add(menu);
                    }
                }
            }
            for (String a : result) {
                answer.add(a);
            }
            Collections.sort(answer);
        }
        return answer.stream().toArray(String[]::new);
    }
    
    public void dfs(int index, int count, int r, String select) {
        if (count == r) {
            selectedMenu.add(select);
            return;
        }
        if (index == menu.length) return;
        for (int i = index; i < menu.length; i++) {
            dfs(i + 1, count + 1, r, select + menu[i]);
        }
    }
}