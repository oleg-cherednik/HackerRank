import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.08.2018
 */
public class Solution {

    static int hourglassSum(int[][] arr) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr[j][i] + arr[j][i + 1] + arr[j][i + 2];
                sum += arr[j + 1][i + 1];
                sum += arr[j + 2][i] + arr[j + 2][i + 1] + arr[j + 2][i + 2];
                res = Math.max(res, sum);
            }
        }

        return res;
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

        int result = hourglassSum(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
