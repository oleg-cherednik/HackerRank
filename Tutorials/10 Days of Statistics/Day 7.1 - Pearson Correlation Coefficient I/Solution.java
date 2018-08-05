import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        /* Read and save input */
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        double[] xs = new double[size];
        double[] ys = new double[size];
        for (int i = 0; i < size; i++) {
            xs[i] = scan.nextDouble();
        }
        for (int i = 0; i < size; i++) {
            ys[i] = scan.nextDouble();
        }

        System.out.println(pearson(xs, ys));
    }

    private static Double pearson(double[] xs, double[] ys) {
        if (xs == null || ys == null || xs.length != ys.length) {
            return null;
        }

        final double xMean = getMean(xs);
        final double yMean = getMean(ys);
        int n = xs.length;

        double numerator = 0;
        for (int i = 0; i < xs.length; i++) {
            numerator += (xs[i] - xMean) * (ys[i] - yMean);
        }
        return numerator / (n * standardDeviation(xs, xMean) * standardDeviation(ys, yMean));
    }

    private static Double getMean(double[] array) {
        if (array == null) {
            return null;
        }
        double total = 0;
        for (double num : array) {
            total += num;
        }
        return total / array.length;
    }

    private static double standardDeviation(double[] array, double mean) {
        double sum = 0;

        for (double x : array)
            sum += Math.pow(x - mean, 2);

        return Math.sqrt(sum / array.length);
    }

}

