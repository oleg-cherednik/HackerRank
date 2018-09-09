import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 09.09.2018
 */
public class Solution {

    private static final Map<Integer, Integer> MAP = new HashMap<>();

    static int findAmicableSum(int N) {
        int res = 0;

        for (int a = 1; a <= N; a++) {
            MAP.computeIfAbsent(a, Solution::getDivisorsSum);
            int b = MAP.get(a);

            MAP.computeIfAbsent(b, Solution::getDivisorsSum);
            int c = MAP.get(b);

            if (a >= b || a != c)
                continue;

            res += a < N ? a : 0;
            res += b < N ? b : 0;
        }

        return res;
    }

    private static int getDivisorsSum(int val) {
        int sum = 0;

        for (int i = 1, sqrt = (int)Math.sqrt(val); i <= val / 2; i++) {
            if (i == sqrt && sum == 1)
                break;
            if (val % i == 0)
                sum += i;
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
