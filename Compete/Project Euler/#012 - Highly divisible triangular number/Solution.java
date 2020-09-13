import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.LongFunction;

/**
 * http://codeforces.com/blog/entry/21202
 *
 * @author Oleg Cherednik
 * @since 15.08.2018
 */
public class Solution {

    private static final Map<Long, Integer> MAP = new HashMap<>();
    private static final LongFunction<Long> GET_TRIANGLE = value -> Math.floorDiv(value * (value + 1), 2);

    private static long getHighlyDivisibleTriangularNumber(int N) {
        long num = 1;
        long triangle = GET_TRIANGLE.apply(num);
        int count = numberOfDivisors(triangle);
        MAP.put(num, count);

        while (count <= N) {
            num++;
            triangle = GET_TRIANGLE.apply(num);
            count = numberOfDivisors(triangle);
            MAP.put(triangle, count);
        }

        return triangle;
    }

    private static int numberOfDivisors(long triangle) {
        return MAP.computeIfAbsent(triangle, tmp -> {
            int divCount = 1;
            int count = 0;

            while (tmp % 2 == 0) {
                tmp = Math.floorDiv(tmp, 2);
                count++;
            }

            divCount *= count + 1;

            for (int i = 3, sqrt = (int)Math.sqrt(tmp); i <= sqrt; i++) {
                count = 0;

                while (tmp % i == 0) {
                    count++;
                    tmp = Math.floorDiv(tmp, i);
                }

                divCount *= count + 1;
            }

            return tmp > 2 ? divCount * 2 : divCount;
        });
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scan.nextInt();
                System.out.println(getHighlyDivisibleTriangularNumber(N));
            }
        }
    }

//    public static void main(String... args) {
//        System.out.println(getHighlyDivisibleTriangularNumber(500));
//    }

}
