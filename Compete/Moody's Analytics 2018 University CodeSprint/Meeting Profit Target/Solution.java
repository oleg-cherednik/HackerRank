import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(in.readLine());
            int[] actual = new int[10_000];
            int[] estimated = new int[10_000];

            for (int i = 0; i < q; i++) {
                int n = Integer.parseInt(in.readLine());

                for (int j = 0; j < n; j++) {
                    String str = in.readLine();
                    int pos = str.indexOf(' ');

                    actual[j] = Integer.parseInt(str.substring(0, pos));
                    estimated[j] = Integer.parseInt(str.substring(pos + 1));
                }

                System.out.println(solve(n, actual, estimated));
            }
        }
    }

}
