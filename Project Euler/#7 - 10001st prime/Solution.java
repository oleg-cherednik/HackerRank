import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    private static final Map<Integer, Boolean> PRIMES = new HashMap<>();

    static int findPrime(long n) {
        for (int i = 1, pos = 0; ; i++) {
            if (isPrime(i))
                if (++pos == n)
                    return i;
        }
    }

    private static boolean isPrime(int val) {
        if (val < 2)
            return false;

        if (PRIMES.containsKey(val))
            return PRIMES.get(val);

        boolean prime = true;
        int sqrt = (int)Math.sqrt(val);

        for (int i = 2; i <= sqrt; i++) {
            if (val % i == 0) {
                prime = false;
                break;
            }
        }

        PRIMES.put(val, prime);
        return prime;
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
