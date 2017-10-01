import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] A = new int[2][n + 1];

        for (int i = 1; i <= n; i++) {
            A[0][i] = scan.nextInt();
            A[1][i] = A[1][i - 1] + A[0][i];
        }

        int res = 0;

        for (int i = 0; i <= n; i++)
            if (A[0][i] < 0)
                res++;

        for (int i = 2; i <= n; i++)
            for (int j = 0, k = j + i; k <= n; j++, k++)
                if (A[1][k] - A[1][j] < 0)
                    res++;

        System.out.println(res);
    }
}
