package cop.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <h1>Java Primality Test</h1>
 * A prime number is a natural number greater than 1 whose only positive divisors are 1 and itself. For example, the first six prime numbers are 2,
 * 3,
 * 4, 7, 11, and 13.<br>
 * <br>
 * Given a large integer, <tt>n</tt>, use the Java <tt>BigInteger</tt> class' isProbablePrime method to determine and print whether it's
 * <tt>prime</tt> or <tt>not prime</tt>.
 * <h3>Input Format</h3>
 * A single line containing an integer, <tt>n</tt> (the number to be checked).
 * <h3>Constraints</h3>
 * <ul>
 * <li><tt>n</tt> contains at most 100 digits.</li>
 * </ul>
 * <h3>Output Format</h3>
 * If <tt>n</tt> is a prime number, print <tt>prime</tt>; otherwise, print <tt>not prime</tt>.
 * <h3>Sample Input</h3>
 * <pre>
 * 13
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * prime
 * </pre>
 * <h3>Explanation</h3>
 * The only positive divisors of 13 are 1 and 13, so we print <tt>prime</tt>.
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaPrimalityTest {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();

        System.out.println(n.isProbablePrime(3) ? "prime" : "not prime");
    }
}
