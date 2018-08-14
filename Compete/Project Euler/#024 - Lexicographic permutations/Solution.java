import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    private static final String STR = "abcdefghijklm";
    private static final long[] FACT = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };

    private static String lexicographicPermutation(long n) {
        n--;
        char[] arr = STR.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            long fact = FACT[arr.length - i - 2];
            long p = i + n / fact;

            n %= fact;

            for (int j = i + 1; j <= p; j++)
                swap(arr, i, j);
        }

        return new String(arr);
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
