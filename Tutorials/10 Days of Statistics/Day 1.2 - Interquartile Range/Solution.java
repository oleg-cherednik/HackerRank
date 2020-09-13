import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static int[] repeat(int x, int f) {
        int[] arr = new int[f];
        Arrays.fill(arr, x);
        return arr;
    }

    private static double median(int[] arr) {
        int m = arr.length / 2;
        return arr.length % 2 == 0 ? (arr[m - 1] + arr[m]) / 2. : (double)arr[m];
    }

    private static double interquartileRange(int[] X, int[] F) {
        int[] S = IntStream.range(0, X.length)
                           .boxed()
                           .map(i -> repeat(X[i], F[i]))
                           .flatMapToInt(Arrays::stream)
                           .sorted()
                           .toArray();

        int m = S.length / 2;
        double q1 = median(Arrays.copyOfRange(S, 0, m));
        double q3 = median(Arrays.copyOfRange(S, S.length % 2 == 0 ? m : m + 1, S.length));
        return q3 - q1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] X = new int[n];
        int[] F = new int[n];

        for (int i = 0; i < n; i++)
            X[i] = scan.nextInt();

        for (int i = 0; i < n; i++)
            F[i] = scan.nextInt();

        System.out.println(interquartileRange(X, F));
    }
}
