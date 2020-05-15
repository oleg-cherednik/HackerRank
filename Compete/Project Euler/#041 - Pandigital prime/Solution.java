import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 15.05.2018
 */
public class Solution {

    static long getLargestPandigitalPrime(long N) {
        int total = String.valueOf(N).length();

        for (int length = total; length > 0; length--) {
            long max = primePermutations(length).stream()
                                                .filter(permutation -> permutation <= N)
                                                .max(Long::compare).orElse(-1L);

            if (max > 0)
                return max;
        }

        return -1;
    }

    private static final Map<Integer, Set<Long>> PRIME_PERMUTATIONS = new HashMap<>();
    private static final IntFunction<Set<Long>> GET_PRIME_PERMUTATIONS = length -> {
        String str = IntStream.rangeClosed(1, length).mapToObj(String::valueOf).collect(Collectors.joining());
        return primePermutations(0, str, new HashSet<>());
    };

    private static Set<Long> primePermutations(int length) {
        PRIME_PERMUTATIONS.computeIfAbsent(length, GET_PRIME_PERMUTATIONS::apply);
        return PRIME_PERMUTATIONS.get(length);
    }

    private static Set<Long> primePermutations(long prefix, String str, Set<Long> res) {
        if (str.isEmpty()) {
            if (isPrime(prefix))
                res.add(prefix);
        } else
            for (int i = 0; i < str.length(); i++)
                primePermutations(prefix * 10 + (str.charAt(i) - '0'), str.substring(0, i) + str.substring(i + 1), res);

        return res;
    }

    private static final Map<Long, Boolean> PRIMES = new HashMap<>();
    private static final LongPredicate IS_PRIME = val -> {
        if (val < 2)
            return false;

        for (int i = 2, sqrt = (int)Math.sqrt(val); i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    };

    private static boolean isPrime(long val) {
        PRIMES.computeIfAbsent(val, IS_PRIME::test);
        return PRIMES.get(val);
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++) {
                long N = scan.nextLong();
                System.out.println(getLargestPandigitalPrime(N));
            }
        }
    }
}
