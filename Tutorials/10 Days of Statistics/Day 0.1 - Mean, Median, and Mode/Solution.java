import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    private static double mean(int[] arr) {
        int sum = 0;

        for (int val : arr)
            sum += val;

        return (double)sum / arr.length;
    }

    private static double median(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        int m = arr.length / 2;
        return arr.length % 2 == 0 ? (arr[m - 1] + arr[m]) / 2. : (double)arr[m];
    }

    private static int mode(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int val : arr)
            map.put(val, map.getOrDefault(val, 0) + 1);

        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();

        return map.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == max)
                  .findFirst().get().getKey();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = scan.nextInt();

            System.out.printf(Locale.US, "%.1f\n", mean(arr));
            System.out.printf(Locale.US, "%.1f\n", median(arr));
            System.out.printf(Locale.US, "%d\n", mode(arr));
        }
    }
}
