import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.11.2018
 */
public class Solution {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++)
            min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));

        return min;
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

        int result = minimumAbsoluteDifference(arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
