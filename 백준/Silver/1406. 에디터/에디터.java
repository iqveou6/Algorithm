import javax.swing.text.StyleConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for(char i : input.toCharArray()) {
            list.add(i);
        }
        ListIterator<Character> iterator = list.listIterator(list.size());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            char character = 0;
            String[] commend = br.readLine().split(" ");
            String c = commend[0];
            if (c.equals("P")) character = commend[1].charAt(0);
            if (c.equals("L")) {
                if (iterator.hasPrevious()) iterator.previous();
            } else if (c.equals("D")) {
                if (iterator.hasNext()) iterator.next();
            } else if (c.equals("B")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else {
                iterator.add(character);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb.toString());

    }
}
