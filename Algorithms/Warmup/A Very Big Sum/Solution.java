import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.05.2018
 */
public class Solution {

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int arCount = scanner.nextInt();

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
