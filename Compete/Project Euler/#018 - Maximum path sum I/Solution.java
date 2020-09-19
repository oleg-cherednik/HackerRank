import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    public static int findMaxSum(int[][] data) {
        for (int row = data.length - 2; row >= 0; row--)
            for (int col = 0; col < data[row].length; col++)
                data[row][col] += Math.max(data[row + 1][col], data[row + 1][col + 1]);

        return data[0][0];
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int cols = 2 * N - 1;
            int[][] data = new int[N][];

            for (int row = 0, j = cols / 2; row < N; row++, j--) {
                data[row] = new int[row + 1];

                for (int col = 0; col < data[row].length; col++)
                    data[row][col] = scan.nextInt();
            }

            System.out.println(findMaxSum(data));
        }
    }

}
