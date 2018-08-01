import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.08.2018
 */
public class Solution {

    static int minimumSwaps(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == i + 1)
                continue;

            swap(arr, i, arr[i] - 1);
            res++;
            i--;
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

        int res = minimumSwaps(arr);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
