import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    private static long fact(long n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    private static String lexicographicPermutation(long n) {
        final String B = "abcdefghijklm";
        char[] A = B.toCharArray();
        int l = B.length();

        n--;
        for (int i = 0; i < l - 1; ++i) {
            long f = fact(l - 1 - i);
            long p = i + n / f;
            n %= f;
            for (int j = i + 1; j <= p; ++j) {
                char temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return new String(A);
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(lexicographicPermutation(scan.nextLong()));
        }
    }

}
