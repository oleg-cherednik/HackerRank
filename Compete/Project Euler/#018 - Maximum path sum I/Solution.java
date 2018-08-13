import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    private static int findMaxSum(int[][] data) {
        int res = 0;

        for (int row = 1; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == 0)
                    continue;

                int prv1 = col > 0 ? data[row - 1][col - 1] : 0;
                int prv2 = col < data.length - 1 ? data[row - 1][col + 1] : 0;
                data[row][col] += Math.max(prv1, prv2);

                if (row == data.length - 1)
                    res = Math.max(res, data[row][col]);
            }
        }

        return res;
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scan.nextInt();
                int cols = 2 * N - 1;
                int[][] data = new int[N][cols];

                scan.nextLine();

                for (int row = 0, j = cols / 2; row < N; row++, j--) {
                    String[] nums = scan.nextLine().split(" ");

                    for (int col = j, k = 0; k <= row; col += 2, k++)
                        data[row][col] = Integer.parseInt(nums[k]);
                }

                System.out.println(findMaxSum(data));
            }
        }
    }

}
