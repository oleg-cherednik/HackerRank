import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    private static int latticePath(int N, int M) {
        int[] row = new int[M + 1];

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= M; j++)
                row[j] = i == 0 || j == 0 ? 1 : (row[j] + row[j - 1]) % 1000000007;

        return row[M];
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scan.nextInt();
                int M = scan.nextInt();

                System.out.println(latticePath(N, M));
            }
        }
    }

}
