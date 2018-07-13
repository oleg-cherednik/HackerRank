import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int twoCharaters(String s) {
        int max = 0;

        if (s.length() >= 2)
            for (int i = 0; i < 25; i++)
                for (int j = i + 1; j < 26; j++)
                    max = Math.max(max, length(s, (char)('a' + i), (char)('a' + j)));

        return max;
    }

    private static int length(String s, char ch1, char ch2) {
        char prv = '\0';
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch1 && s.charAt(i) != ch2)
                continue;
            if (prv != '\0' && prv == s.charAt(i))
                return 0;

            length++;
            prv = s.charAt(i);
        }

        return length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = twoCharaters(s);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
