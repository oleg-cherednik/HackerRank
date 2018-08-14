import java.util.Scanner;
import java.util.function.IntPredicate;

/**
 * @author Oleg Cherednik
 * @since 14.08.2018
 */
public class Solution {

    private static final long[][] primes = new long[2][15];

    static {
        final IntPredicate isPrime = val -> {
            if (val < 2)
                return false;

            for (int i = 2, sqrt = (int)Math.sqrt(val); i <= sqrt; i++)
                if (val % i == 0)
                    return false;

            return true;
        };

        for (int i = 0, j = 0; i < primes[0].length; j++) {
            if (!isPrime.test(j))
                continue;

            primes[0][i] = j;
            primes[1][i] = i > 0 ? primes[1][i - 1] * j : j;
            i++;
        }
    }

    static int primeCount(long n) {
        int i = 0;

        for (; i < primes[0].length; i++)
            if (primes[1][i] > n)
                break;

        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(scanner.nextLine().trim());

            int result = primeCount(n);

            System.out.println(String.valueOf(result));
        }
    }

}
