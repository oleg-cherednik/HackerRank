import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    static int sockMerchant(int n, int[] ar) {
        List<Integer> res;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
