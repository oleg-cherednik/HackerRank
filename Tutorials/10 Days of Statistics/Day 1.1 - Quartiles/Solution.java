import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static int median(int[] arr) {
        int m = arr.length / 2;
        return arr.length % 2 == 0 ? (arr[m - 1] + arr[m]) / 2 : arr[m];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] X = new int[n];

        for (int i = 0; i < n; i++)
            X[i] = scan.nextInt();

        Arrays.sort(X);

        int m = X.length / 2;
        System.out.println(median(Arrays.copyOfRange(X, 0, m)));
        System.out.println(median(X));
        System.out.println(median(Arrays.copyOfRange(X, X.length % 2 == 0 ? m : m + 1, X.length)));
    }
}
