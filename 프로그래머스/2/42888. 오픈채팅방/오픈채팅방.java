import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        String[][] chattingroom = new String[record.length][2];
        int index = 0;
        for (String r : record) {
            String[] input = r.split(" ");
            String way = input[0];
            String uid = input[1];
            if (!way.equals("Leave")) {
                String name = input[2];
                if (way.equals("Enter")) {
                    chattingroom[index++] = new String[] {uid, "님이 들어왔습니다."};
                }
                map.put(uid, name);
            } else {
                chattingroom[index++] = new String[] {uid, "님이 나갔습니다."};
            }
        }
        String[] answer = new String[index];
        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(chattingroom[i][0])).append(chattingroom[i][1]);
            answer[i] = sb.toString();
        }
        return answer;
    }
}