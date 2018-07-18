import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static int flatlandSpaceStations(int n, int[] c) {
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        for (int city : c)
            arr[city] = 0;

        for (int i = 0, j = -1; i < arr.length; i++) {
            if (arr[i] == 0)
                j = i;
            else if (j != -1)
                arr[i] = i - j;
        }

        int res = 0;

        for (int i = arr.length - 1, j = -1; i >= 0; i--) {
            if (arr[i] == 0)
                j = i;
            else if (j != -1)
                arr[i] = arr[i] != -1 ? Math.min(arr[i], j - i) : j - i;

            res = Math.max(res, arr[i]);
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
