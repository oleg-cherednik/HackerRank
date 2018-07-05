import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.07.2018
 */
public class Solution {

    static long flippingBits(long n) {
        return ~n & 0xFFFFFFFFL;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
