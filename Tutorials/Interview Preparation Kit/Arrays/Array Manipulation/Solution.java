import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.08.2018
 */
public class Solution {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];

            if (k > 0) {
                arr[a - 1] += k;

                if (b < arr.length)
                    arr[b] -= k;
            }
        }

        long max = arr[0];
        long cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur += arr[i];
            max = cur > max ? cur : max;
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
