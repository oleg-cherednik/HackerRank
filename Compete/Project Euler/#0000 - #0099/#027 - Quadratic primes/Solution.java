import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntPredicate;

/**
 * @author Oleg Cherednik
 * @since 09.08.2018
 */
public class Solution {

    static int[] findCoefficients(int N) {
        int max = 0;
        int a = 0;
        int b = 0;

        for (int aa = -N; aa <= N; aa++) {
            for (int bb = -N, n = 0; bb <= N; bb++, n = 0) {
                while (isPrime(solve(n, aa, bb))) {
                    n++;
                }

                if (n > max) {
                    max = n;
                    a = aa;
                    b = bb;
                }
            }
        }

        return new int[] { a, b };
    }

    private static int solve(int n, int a, int b) {
        return n * n + a * n + b;
    }

    private static final Map<Integer, Boolean> MAP = new HashMap<>();
    private static final IntPredicate IS_PRIME = val -> {
        if (val < 2)
            return false;

        int sqrt = (int)Math.sqrt(val);

        for (int i = 2; i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    };

    private static boolean isPrime(int val) {
        val = Math.abs(val);
        MAP.putIfAbsent(val, IS_PRIME.test(val));
        return MAP.get(val);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] res = findCoefficients(scan.nextInt());
        System.out.format("%d %d\n", res[0], res[1]);
    }

}
