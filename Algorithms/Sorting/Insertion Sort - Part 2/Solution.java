import java.util.Scanner;
import java.util.function.Consumer;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static void insertionSort2(int n, int[] arr) {
        for (int i = 1, j = i - 1; i < arr.length; i++, j = i - 1) {
            int x = arr[i];

            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j -= 1;
            }

            arr[j + 1] = x;
            PRINT.accept(arr);
        }
    }

    private static final Consumer<int[]> PRINT = arr -> {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(arr[i]);
        }

        System.out.println();
    };

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

        insertionSort2(n, arr);

        scanner.close();
    }
}
