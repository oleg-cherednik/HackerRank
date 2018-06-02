import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 01.06.2018
 */
public class Solution {

    static long countInversions(int[] arr) {
        int res = 0;

        Set<Integer> values = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(values.contains(arr[i]))
                continue;

            for(int j = arr.length - 1; j >i; j--) {
                if (arr[j] <= arr[i]) {
                    res = Math.max(res, j - i);
                    break;
                }
            }

            values.add(arr[i]);
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }

}
