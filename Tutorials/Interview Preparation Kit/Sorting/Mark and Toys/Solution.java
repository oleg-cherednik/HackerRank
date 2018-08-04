import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int pos = 0;

        while (pos < prices.length && prices[pos] <= k) {
            pos++;
        }

        if (pos == 0)
            return 0;

        int count = 0;

        for (int i = pos - 1, j; i >= 0; i--) {
            int sum = prices[i];

            for (j = 0; j < i && sum + prices[j] <= k; j++)
                sum += prices[j];

            count = Math.max(count, j + 1);

            if (i == j)
                break;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
