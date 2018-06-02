import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int pickingNumbers(int[] a) {
        Arrays.sort(a);

        int res = 0;

        for (int i = 0; i < a.length - res; i++) {
            int j = i + 1;

            while (j < a.length && a[j] - a[i] <= 1) {
                j++;
            }

            res = Math.max(res, j - i);
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
