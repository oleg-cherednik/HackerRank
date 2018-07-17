import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static int[] quickSort(int[] arr) {
        List<Integer> left = new LinkedList<>();
        List<Integer> equal = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        int p = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < p)
                left.add(arr[i]);
            else if (arr[i] == p)
                equal.add(arr[i]);
            else if (arr[i] > p)
                right.add(arr[i]);
        }

        int i = 0;
        int[] res = new int[arr.length];

        for (int val : left)
            res[i++] = val;
        for (int val : equal)
            res[i++] = val;
        for (int val : right)
            res[i++] = val;

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

        int[] result = quickSort(arr);

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
