import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    static int findPrime(int n) {
        for (int i = 1, pos = 0; ; i++)
            if (isPrime(i))
                if (++pos == n)
                    return i;
    }

    private static final Map<Integer, Boolean> PRIMES = new HashMap<>();

    private static boolean isPrime(int val) {
        return PRIMES.computeIfAbsent(val, v -> {
            if (v < 2)
                return false;

            for (int i = 2, sqrt = (int)Math.sqrt(v); i <= sqrt; i++)
                if (v % i == 0)
                    return false;

            return true;
        });
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(findPrime(n));
        }
    }

}
