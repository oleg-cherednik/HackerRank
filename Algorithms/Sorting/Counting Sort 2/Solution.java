import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static int[] countingSort(int[] arr) {
        int[] count = new int[100];

        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        int[] res = new int[arr.length];

        for (int i = 0, j = 0; i < count.length; i++)
            for (int k = 0; k < count[i]; k++)
                res[j++] = i;

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

        int[] result = countingSort(arr);

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
