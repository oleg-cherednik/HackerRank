import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double mu = scan.nextDouble();
            double sigma = scan.nextDouble();
            double upperSolo = scan.nextDouble();
            double lower = scan.nextDouble();
            double upper = scan.nextDouble();

            final Function<Double, Double> normalDistribution = x ->
                    Math.pow(Math.E, -(Math.pow(x - mu, 2) / (2 * Math.pow(sigma, 2)))) / (sigma * Math.sqrt(2 * Math.PI));

            System.out.printf(Locale.US, "%.3f\n", integrate(normalDistribution, mu - 5 * sigma, upperSolo));
            System.out.printf(Locale.US, "%.3f\n", integrate(normalDistribution, lower, upper));
        }
    }

    public static double integrate(Function<Double, Double> func, double a, double b) {
        double dx = 1e-5;
        double sum = 0;

        for (double x = a; x <= b; x += dx)
            sum += func.apply(x) * dx;

        return sum;
    }

}
