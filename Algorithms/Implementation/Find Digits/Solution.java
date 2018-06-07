import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.06.2018
 */
public class Solution {

    static int findDigits(int n) {
        int res = 0;

        for (char ch : String.valueOf(n).toCharArray())
            if (ch != '0' && n % (ch - '0') == 0)
                res++;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
