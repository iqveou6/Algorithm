import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int[] arrA = new int[26];
        int[] arrB = new int[26];
        for (char c : a.toCharArray()) {
            arrA[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            arrB[c - 'a']++;
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            int result = arrA[i] - arrB[i];
            if (result < 0) answer -= result;
            else answer += result;
        }
        System.out.println(answer);
    }
}
