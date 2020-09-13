import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double lambda = scan.nextDouble();
        int k = scan.nextInt();
        System.out.format(Locale.US, "%.3f\n", poisson(k, lambda));
    }

    private static double poisson(int k, double lambda) {
        return (Math.pow(lambda, k) * Math.pow(Math.E, -1 * lambda)) / fact(k);
    }

    private static long fact(int n) {
        return n == 0 || n == 1 ? 1 : n * fact(n - 1);
    }
}
