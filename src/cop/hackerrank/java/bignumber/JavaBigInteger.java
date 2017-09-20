package cop.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <h1>Java BigInteger</h1>
 * In this problem, you have to add and multiply huge numbers! These numbers are so big that you can't contain them in any ordinary data types like a
 * long integer.<br>
 * <br>
 * Use the power of Java's BigInteger class and solve this problem.
 * <h3>Input Format</h3>
 * There will be two lines containing two numbers, <tt>a</tt> and <tt>b</tt>.
 * <h3>Constraints</h3>
 * <tt>a</tt> and <tt>b</tt> are non-negative integers and can have maximum 200 digits.
 * <h3>Output Format</h3>
 * Output two lines. The first line should contain <tt>a + b</tt>, and the second line should contain <tt>a × b</tt>. Don't print any leading zeros.
 * <h3>Sample Input</h3>
 * <pre>
 * 1234
 * 20
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 1254
 * 24680
 * </pre>
 * <h3>Explanation</h3>
 * 1234 + 20 = 1254<br>
 * 1234 × 20 = 24680
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaBigInteger {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        scan.close();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
