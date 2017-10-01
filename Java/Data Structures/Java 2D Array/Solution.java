import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                arr[i][j] = in.nextInt();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr[j][i] + arr[j][i + 1] + arr[j][i + 2];
                sum += arr[j + 1][i + 1];
                sum += arr[j + 2][i] + arr[j + 2][i + 1] + arr[j + 2][i + 2];
                res = Math.max(res, sum);
            }
        }

        System.out.println(res);
    }
}
