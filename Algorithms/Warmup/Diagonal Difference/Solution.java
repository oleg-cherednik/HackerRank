import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.05.2018
 */
public class Solution {

    static int diagonalDifference(int[][] a) {
        int res = 0;

        for(int i = 0; i < a.length; i++)
            res += a[i][i] - a[i][a.length - i - 1];

        return Math.abs(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int aItem = Integer.parseInt(aRowItems[j]);
                a[i][j] = aItem;
            }
        }

        int result = diagonalDifference(a);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
