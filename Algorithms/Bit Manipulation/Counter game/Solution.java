import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.07.2018
 */
public class Solution {

    static String counterGame(long n) {
        boolean richard = true;

        do {
            n = isPowerOfTwo(n) ? n >> 1 : (n - prvPowerOfTwo(n));
            richard = !richard;
        } while (n != 1);

        return richard ? "Richard" : "Louise";
    }

    private static long prvPowerOfTwo(long val) {
        val |= val >> 1;
        val |= val >> 2;
        val |= val >> 4;
        val |= val >> 8;
        val |= val >> 16;
        return val - (val >> 1);
    }

    private static boolean isPowerOfTwo(long val) {
        return ((val - 1) & val) == 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);
            System.out.println(result);
        }

        scanner.close();
    }
}
