import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.17.2018
 */
public class Solution {

    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);

        int[] res = new int[(int)Arrays.stream(arr).distinct().count()];

        for (int i = 0, k = 0, m = 0; i < arr.length; i++, k = 0) {
            if (arr[i] == 0)
                continue;

            int sub = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (arr[j] != 0) {
                    k++;
                    arr[j] -= sub;
                }
            }

            res[m++] = k;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
