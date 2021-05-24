import java.util.Scanner;

/**
 * <a href="https://en.wikipedia.org/wiki/Ulam_spiral">Ulam spiral</a>
 *
 * @author Oleg Cherednik
 * @since 24.05.2021
 */
public class Solution {

    /*
     * 1: d1 = (2x + 1)^2 => 4x^2 + 4x + 1
     * 2: d2 = d1 - 2x    => 4x^2 + 2x + 1
     * 3: d3 = d2 - 2x    => 4x^2 + 1
     * 4: d4 = d3 - 2x    => 4x^2 - 2x + 1
     *
     * 2...1
     * .2.1.
     * ..1..
     * .3.4.
     * 3...4
     *
     * sum = 1 + (d1 + d2 + d3 + d4) = 1 + (16x^2 + 4x + 4) for x = 1...N/2
     * a = 8x(n + 1)(2x + 1) / 3
     * b = 2x(x + n)
     * c = 4x
     * d = 1
     */
    private static final long MODULO = 1_000_000_007;

    static long findDiagonalSum(long N) {
        long n = N / 2;
        long a = inverseModulo(8, replaceDividable(n, n + 1, 2 * n + 1));
        long b = inverseModulo(2, n, n + 1);
        long c = inverseModulo(4, n);
        long d = 1;
        return (a + b + c + d) % MODULO;
    }

    private static long[] replaceDividable(long... nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 3 == 0L)
                nums[i] /= 3;

        return nums;
    }

    private static int inverseModulo(long base, long... nums) {
        base %= MODULO;

        for (int i = 0; i < nums.length; i++)
            nums[i] %= MODULO;
        for (long i : nums)
            base = (base * i) % MODULO;

        return (int)base;
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(findDiagonalSum(scan.nextLong()));
    }

}
