import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.06.2018
 */
public class Solution {

    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
        int value = 0;

        for (int i : a)
            value ^= i;

        return value;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        System.out.println(result);

        scanner.close();
    }
}
