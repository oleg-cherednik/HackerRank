/**
 * <p>By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.</p>
 * <p>What is the 10 001st prime number?</p><p>Find the difference between the sum of the squares of the first one hundred natural numbers and the
 * square of the sum.</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        System.out.println(Solution.findPrime(10_001));  // 104743
    }
}
