import java.util.Locale;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        int[] xs = { 95, 85, 80, 70, 60 };
        int[] ys = { 85, 95, 70, 65, 70 };
        double studentScore = 80;

        final double xMean = mean(xs);
        final double yMean = mean(ys);

        double b = pearson(xs, xMean, ys, yMean) * (standardDeviation(ys, yMean) / standardDeviation(xs, xMean));
        double a = yMean - b * xMean;

        System.out.format(Locale.US, "%.3f\n", a + b * studentScore);
    }

    private static double pearson(int[] xs, double xMean, int[] ys, double yMean) {
        int n = xs.length;

        double numerator = 0;

        for (int i = 0; i < n; i++)
            numerator += (xs[i] - xMean) * (ys[i] - yMean);

        return numerator / (n * standardDeviation(xs, xMean) * standardDeviation(ys, yMean));
    }

    private static double mean(int[] array) {
        double sum = 0;

        for (double num : array)
            sum += num;

        return sum / array.length;
    }

    private static double standardDeviation(int[] arr, double mean) {
        int sum = 0;

        for (int num : arr)
            sum += Math.pow(num - mean, 2);

        return Math.sqrt((double)sum / arr.length);
    }

}

