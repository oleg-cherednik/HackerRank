import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Oleg Cherednik
 * @since 14.08.2018
 */
public class Solution {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private static final BigInteger FIVE = BigInteger.valueOf(5);

    private static final Function<BigInteger, BigInteger> SQRT = val -> {
        if (val.equals(BigInteger.ZERO) || val.equals(BigInteger.ONE))
            return val;

        BigInteger two = TWO;
        BigInteger y;

        for (y = val.divide(two); y.compareTo(val.divide(y)) > 0; y = val.divide(y).add(y).divide(two)) {
        }

        return y;
    };

    private static final Predicate<BigInteger> IS_SQRT = val -> {
        BigInteger sqrt = SQRT.apply(val);
        return sqrt.multiply(sqrt).equals(val);
    };

    static String solve(long n) {
        BigInteger tmp = BigInteger.valueOf(n).pow(2).multiply(FIVE);
        return IS_SQRT.test(tmp.subtract(FOUR)) || IS_SQRT.test(tmp.add(FOUR)) ? "IsFibo" : "IsNotFibo";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = solve(n);

            System.out.println(result);
        }

        scanner.close();
    }

}
