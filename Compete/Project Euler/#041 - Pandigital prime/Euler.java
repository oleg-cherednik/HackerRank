/**
 * <p>We shall say that an <i>n</i>-digit number is pandigital if it makes use of all the digits 1 to <i>n</i> exactly once. For example, 2143 is a
 * 4-digit pandigital and is also prime.</p>
 * <p>What is the largest <i>n</i>-digit pandigital prime that exists?</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        System.out.println(Solution.getLargestPandigitalPrime(9999999999L));    // 7652413
    }

}
