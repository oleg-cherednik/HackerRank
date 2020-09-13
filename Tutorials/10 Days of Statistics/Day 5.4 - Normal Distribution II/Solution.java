import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mean = scan.nextInt();
        int standardDeviation = scan.nextInt();
        int x1 = scan.nextInt();
        int x2 = scan.nextInt();

        System.out.format(Locale.US, "%.2f\n", (1 - normal(x1, mean, standardDeviation)) * 100);
        System.out.format(Locale.US, "%.2f\n", (1 - normal(x2, mean, standardDeviation)) * 100);
        System.out.format(Locale.US, "%.2f\n", normal(x2, mean, standardDeviation) * 100);
    }

    public static double normal(int x, int mean, int standardDeviation) {
        return 0.5 * (1 + erf((x - mean) / (1.4142135623730951 * standardDeviation)));
    }

    /*
     * Princeton's resources: https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-1/forum
     *
     * fractional error in math formula less than 1.2 * 10 ^ -7.
     * although subject to catastrophic cancellation when z in very close to 0
     * from Chebyshev fitting formula for erf(z) from Numerical Recipes, 6.2
     */
    private static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 + t * (1.00002368 + t * (0.37409196 + t * (0.09678418 + t * (-0.18628806
                + t * (0.27886807 + t * (-1.13520398 + t * (1.48851587 + t * (-0.82215223 + t * 0.17087277)))))))));

        if (z >= 0) return ans;
        else return -ans;
    }

}

