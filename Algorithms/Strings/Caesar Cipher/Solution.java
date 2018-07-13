import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String caesarCipher(String s, int k) {
        k %= 26;
        StringBuilder buf = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isAlphabetic(ch))
                ch = (char)(ch + k > 'z' ? ch + k - 'z' + 'a' - 1 : ch + k);

            buf.append(Character.isUpperCase(s.charAt(i)) ? Character.toUpperCase(ch) : ch);
        }

        return buf.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);
        System.out.println(result);

        scanner.close();
    }
}
