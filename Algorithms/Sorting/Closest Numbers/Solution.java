import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);

        int total = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0, j = i + 1; j < arr.length; i++, j++) {
            if (arr[j] - arr[i] > min)
                continue;
            if (arr[j] - arr[i] < min) {
                min = arr[j] - arr[i];
                total = 1;
            } else
                total++;
        }

        int[] res = new int[total * 2];

        for (int i = 0, j = i + 1, k = 0; j < arr.length; i++, j++) {
            if (arr[j] - arr[i] == min) {
                res[k++] = arr[i];
                res[k++] = arr[j];
            }
        }

        return res;
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

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
