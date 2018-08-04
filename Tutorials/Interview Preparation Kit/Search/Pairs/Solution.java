import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        Set<Integer> values = new HashSet<>();

        int res = 0;

        for (int value : arr) {
            values.add(value);

            if (value > k && values.contains(value - k))
                res++;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }

}
