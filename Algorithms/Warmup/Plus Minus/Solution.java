import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.05.2018
 */
public class Solution {

    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;

        for (int val : arr) {
            if (val > 0)
                positive++;
            else if (val < 0)
                negative++;
            else
                zeros++;
        }

        System.out.format(Locale.US, "%.6f\n", positive / (double)arr.length);
        System.out.format(Locale.US, "%.6f\n",  negative / (double)arr.length);
        System.out.format(Locale.US, "%.6f\n",  zeros / (double)arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
