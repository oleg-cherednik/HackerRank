import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntFunction;

/**
 * @author Oleg Cherednik
 * @since 15.08.2018
 */
public class Solution {

    private static final Map<Integer, Integer> MAP = new HashMap<>();
    private static final IntFunction<Integer> GET_TRIANGLE = value -> Math.floorDiv(value * (value + 1), 2);

    private static int getHighlyDivisibleTriangularNumber(int N) {
        int num = 1;
        int triangle = GET_TRIANGLE.apply(num);
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

    private static int numberOfDivisors(int triangle) {
        return MAP.computeIfAbsent(triangle, tmp -> {
            int primePowerCount = 1;
            int count = 0;

            while (tmp % 2 == 0) {
                tmp = Math.floorDiv(tmp, 2);
                count++;
            }

            primePowerCount *= count + 1;

            for (int i = 3; i <= Math.sqrt(tmp); i++) {
                count = 0;

                while (tmp % i == 0) {
                    count++;
                    tmp = Math.floorDiv(tmp, i);
                }

                primePowerCount *= count + 1;
            }

            return tmp > 2 ? primePowerCount * 2 : primePowerCount;
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

}
