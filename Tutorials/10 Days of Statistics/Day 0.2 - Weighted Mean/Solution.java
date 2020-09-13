import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static double weightedMean(int[] X, int[] W) {
        int sum_x = IntStream.range(0, X.length).map(i -> X[i] * W[i]).sum();
        int sum_w = Arrays.stream(W).sum();
        return (double)sum_x / sum_w;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] X = new int[N];
        int[] W = new int[N];

        for (int i = 0; i < N; i++)
            X[i] = scan.nextInt();

        for (int i = 0; i < N; i++)
            W[i] = scan.nextInt();

        System.out.printf(Locale.US, "%.1f\n", weightedMean(X, W));
    }
}
