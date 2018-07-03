import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.07.2018
 */
public class Solution {

    static int minimumDistances(int[] a) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    res = Math.min(res, j - i);
                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
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

        int result = minimumDistances(a);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
