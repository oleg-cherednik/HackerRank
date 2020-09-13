import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double p = scan.nextDouble() / 100;
        int n = scan.nextInt();
        double res = 0;

        for (int i = 0; i <= 2; i++)
            res += binomial(n, i, p);

        System.out.format(Locale.US, "%.3f\n", res);
        System.out.format(Locale.US, "%.3f\n", 1 - binomial(n, 0, p) - binomial(n, 1, p));
    }

    private static double binomial(int n, int i, double p) {
        return p < 0 || p > 1 || n < 0 || i < 0 || i > n ? 0 : combinations(n, i) * Math.pow(p, i) * Math.pow(1 - p, n - i);
    }

    private static long combinations(int n, int i) {
        return n < 0 || i < 0 || i > n ? 1 : fact(n) / (fact(i) * fact(n - i));
    }

    private static long fact(int n) {
        return n == 0 || n == 1 ? 1 : n * fact(n - 1);
    }
}
