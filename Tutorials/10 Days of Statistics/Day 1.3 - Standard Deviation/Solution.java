import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static double mean(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return (double)sum / arr.length;
    }

    private static double standardDeviation(int[] X) {
        double mean = mean(X);

        double sum = IntStream.range(0, X.length)
                              .boxed()
                              .map(i -> Math.pow(X[i] - mean, 2))
                              .mapToDouble(d -> d)
                              .sum();

        return Math.sqrt(sum / X.length);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int[] X = new int[N];

            for (int i = 0; i < N; i++)
                X[i] = scan.nextInt();

            System.out.printf(Locale.US, "%.1f\n", standardDeviation(X));
        }
    }
}
