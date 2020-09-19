import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 10.09.2018
 */
public class Solution {

    private static final Set<Integer> ABUNDANT_NUMBERS = calcAbundantNumbers();

    private static Set<Integer> calcAbundantNumbers() {
        IntPredicate isAbundantNumber = val -> {
            int sum = 0;

            for (int i = 1, sqrt = (int)Math.sqrt(val); i <= sqrt; i++) {
                if (val % i == 0) {
                    sum += i;
                    sum += i > 1 && val / i != i ? val / i : 0;
                }
            }

            return sum > val;
        };

        return IntStream.rangeClosed(1, 100_000)
                        .filter(isAbundantNumber)
                        .boxed()
                        .collect(Collectors.toCollection(TreeSet::new));
    }

    static boolean isAbundantNumbersExpressed(int N) {
        for (int abundantNumber : ABUNDANT_NUMBERS) {
            if (abundantNumber >= N)
                return false;
            if (ABUNDANT_NUMBERS.contains(N - abundantNumber))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(isAbundantNumbersExpressed(scan.nextInt()) ? "YES" : "NO");
    }
}
