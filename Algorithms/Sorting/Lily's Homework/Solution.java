import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static int lilysHomework(int[] arr) {
        int res = Integer.MAX_VALUE;
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        for (int k = 0; k < 2; k++) {
            int swaps = 0;

            if (k == 1)
                for (int l = 0, m = sorted.length - 1; l < m; l++, m--)
                    swap(sorted, l, m);

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++)
                map.put(arr[i], i);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == sorted[i])
                    continue;

                swaps++;
                int j = map.get(sorted[i]);
                map.put(arr[i], map.get(sorted[i]));
                swap(arr, i, j);
            }

            res = Math.min(res, swaps);
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

        int result = lilysHomework(arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
