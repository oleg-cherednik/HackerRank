import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            scan.useLocale(Locale.US);

            int size = scan.nextInt();
            double[] xs = new double[size];
            double[] ys = new double[size];

            for (int i = 0; i < size; i++)
                xs[i] = scan.nextDouble();
            for (int i = 0; i < size; i++)
                ys[i] = scan.nextDouble();

            System.out.println(pearson(xs, ys));
        }
    }

    private static double pearson(double[] xs, double[] ys) {
        final double xMean = mean(xs);
        final double yMean = mean(ys);
        double numerator = 0;

        for (int i = 0; i < xs.length; i++)
            numerator += (xs[i] - xMean) * (ys[i] - yMean);

        return numerator / (xs.length * standardDeviation(xs, xMean) * standardDeviation(ys, yMean));
    }

    private static double mean(double[] arr) {
        double sum = 0;

        for (double num : arr)
            sum += num;

        return sum / arr.length;
    }

    private static double standardDeviation(double[] arr, double mean) {
        double sum = 0;

        for (double num : arr)
            sum += Math.pow(num - mean, 2);

        return Math.sqrt(sum / arr.length);
    }

}

