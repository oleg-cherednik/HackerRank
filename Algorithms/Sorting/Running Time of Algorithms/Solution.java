import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static int runningTime(int[] arr) {
        int res = 0;

        for (int i = 1, j = i - 1; i < arr.length; i++, j = i - 1) {
            int x = arr[i];

            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j -= 1;
                res++;
            }

            arr[j + 1] = x;
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

        int result = runningTime(arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
