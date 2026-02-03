import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            }
        }
        System.out.println(answer);
    }
}