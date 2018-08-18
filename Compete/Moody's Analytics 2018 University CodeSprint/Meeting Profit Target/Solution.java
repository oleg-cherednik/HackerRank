import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {
    static int solve(int n, int[] actual, int[] estimated) {
        long sum = 0;

        for (int i = 0; i < n; i++)
            sum = Math.min(0, sum + actual[i] - estimated[i]);

        return sum < 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int q = scan.nextInt();

            for (int i = 0; i < q; i++) {
                int n = scan.nextInt();
                int[] actual = new int[n];
                int[] estimated = new int[n];

                for (int j = 0; j < n; j++) {
                    actual[j] = scan.nextInt();
                    estimated[j] = scan.nextInt();
                }

                System.out.println(solve(n, actual, estimated));
            }
        }
    }

}
