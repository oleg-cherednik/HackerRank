import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.06.2018
 */
public class Solution {

    static long repeatedString(String s, long n) {
        long j = n % s.length();
        long total = 0;
        long part = 0;

        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'a') {
                total++;
                part += k < j ? 1 : 0;
            }
        }

        return total * (n / s.length()) + part;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
