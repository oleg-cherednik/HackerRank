import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int pickingNumbers(int[] a) {
        Arrays.sort(a);

        int res = a.length > 0 ? 1 : 0;

        for (int i = 0, k = 1, j = 1; j < a.length; j++) {
            if (a[j] - a[i] > 1) {
                i = k == i ? j : k;
                j = i;
            } else {
                res = Math.max(res, j - i + 1);

                if (a[j] != a[k])
                    k = j;
            }
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
