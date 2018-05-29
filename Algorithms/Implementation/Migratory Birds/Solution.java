import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    static int migratoryBirds(int[] ar) {
        int[] arr = new int[5];

        for (int val : ar)
            arr[val - 1]++;

        int max = Arrays.stream(arr).max().getAsInt();

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == max)
                return i + 1;

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
