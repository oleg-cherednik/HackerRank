import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 10.09.2018
 */
public class Solution {

    private static final Set<Integer> AMICABLE_NUMBERS;

    static {
        Set<Integer> amicableNumbers = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int a = 1; a <= 100_000; a++) {
            map.computeIfAbsent(a, Solution::getDivisorsSum);
            map.computeIfAbsent(map.get(a), Solution::getDivisorsSum);

            int b = map.get(a);
            int c = map.get(b);

            if (a < b && a == c) {
                amicableNumbers.add(a);
                amicableNumbers.add(b);
            }
        }

        AMICABLE_NUMBERS = Collections.unmodifiableSet(amicableNumbers);
    }

    static int findAmicableSum(int N) {
        return AMICABLE_NUMBERS.stream().filter(v -> v < N).mapToInt(v -> v).sum();
    }

    private static int getDivisorsSum(int val) {
        int sum = 0;

        for (int i = 1, sqrt = (int)Math.sqrt(val); i <= sqrt; i++) {
            if (val % i == 0) {
                sum += i;
                sum += i > 1 ? val / i : 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(findAmicableSum(scan.nextInt()));
        }
    }
}
