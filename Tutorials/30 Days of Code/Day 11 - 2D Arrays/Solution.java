import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    private static int maxHourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        final int size = arr.length - 2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a = arr[i][j];
                int b = arr[i][j + 1];
                int c = arr[i][j + 2];
                int d = arr[i + 1][j + 1];
                int e = j < arr[i + 2].length ? arr[i + 2][j] : 0;
                int f = j + 1 < arr[i + 2].length ? arr[i + 2][j + 1] : 0;
                int g = j + 2 < arr[i + 2].length ? arr[i + 2][j + 2] : 0;
                max = Math.max(a + b + c + d + e + f + g, max);
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(maxHourglassSum(arr));

        scanner.close();
    }
}
