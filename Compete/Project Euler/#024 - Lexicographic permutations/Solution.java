import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    private static final Map<Long, char[]> MAP = new HashMap<>();
    private static final String STR = "abcdefghijklm";

    // 13! = 6227020800
    private static String lexicographicPermutation(long n) {
        if (MAP.isEmpty())
            MAP.put(1L, STR.toCharArray());

        long key = MAP.keySet().stream()
                      .filter(k -> k <= n)
                      .mapToLong(i -> i)
                      .max()
                      .orElse(-1);

        if (key != n) {
            char[] arr = new String(MAP.get(key)).toCharArray();

            do {
                key++;

                if (!next(arr))
                    break;

                if(key >= 6227020800L / 2 && key <= 6227020800L / 2 + 50)
                    System.out.println("----------------- " + key + " - " + new String(arr));
            } while (key < n);

            MAP.put(key, arr);
        }

        return new String(MAP.get(n));
    }

    private static boolean next(char[] arr) {
        for (int i = arr.length - 2, j = arr.length; i >= 0; i--, j = arr.length) {
            if (arr[i] >= arr[i + 1])
                continue;

            while (arr[--j] < arr[i]) {
            }

            swap(arr, i, j);

            for (int k = i + 1, l = arr.length - 1; l > k; --l, ++k)
                swap(arr, k, l);

            return true;
        }

        return false;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(lexicographicPermutation(scan.nextLong()));
        }
    }

}
