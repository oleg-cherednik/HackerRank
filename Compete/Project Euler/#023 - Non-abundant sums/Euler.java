/**
 * <p>A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper
 * divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.</p>
 * <p>A number <var>n</var> is called deficient if the sum of its proper divisors is less than <var>n</var> and it is called abundant if this sum
 * exceeds <var>n</var>.</p>
 *
 * <p>As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this
 * upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two
 * abundant numbers is less than this limit.</p>
 * <p>Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        int sum = 0;

        for (int i = 1; i <= 28_123; i++)
            if (!Solution.isAbundantNumbersExpressed(i))
                sum += i;

        System.out.println(sum);    // 4179871
    }
}
