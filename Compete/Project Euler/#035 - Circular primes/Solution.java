import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.IntPredicate;

/**
 * @author Oleg Cherednik
 * @since 15.05.2018
 */
public class Solution {

    static void countCircularPrimes(int N) {
        int sum = 0;

        for (int i = 1; i <= N; i++)
            if (isCircularPrime(i))
                sum += i;

        System.out.println(sum);
    }

    private static boolean isCircularPrime(int val) {
        for (int rot : getAllRotations(val))
            if (!isPrime(rot))
                return false;

        return true;
    }

    private static Set<Integer> getAllRotations(int val) {
        Set<Integer> res = new HashSet<>();
        int total = String.valueOf(val).length();

        for (int i = 0; i < total; i++) {
            val = val % 10 * (int)Math.pow(10, total - 1) + val / 10;
            res.add(val);
        }

        return res;
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
        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            countCircularPrimes(N);
        }
    }
}
