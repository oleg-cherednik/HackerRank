package cop.hackerrank.java.exceptionhandling;

import java.util.Scanner;

/**
 * <h1>Java Exception Handling</h1>
 * Create a class <tt>MyCalculator</tt> which consists of a single method <tt>long power(int, int)</tt>. This method takes two integers, <tt>n</tt>
 * and <tt>p</tt>, as parameters and finds <tt>n<sup>p</sup></tt>. If either <tt>n</tt> or <tt>p</tt> is negative, then the method must throw an
 * exception which says <tt>"n or p should not be negative."</tt>. Also, if both <tt>n</tt> and <tt>p</tt> are zero, then the method must throw an
 * exception which says <tt>"n and p should not be zero."</tt>.
 * <h3>Input Format</h3>
 * Each line of the input contains two integers, <tt>n</tt> and <tt>p</tt>. The locked stub code in the editor reads the input and sends the values
 * to
 * the method as parameters.
 * <h3>Constraints</h3>
 * <ul>
 * <li>-10 <= n <= 19</li>
 * <li>-10 <= p <= 10</li>
 * </ul>
 * <h3>Output Format</h3>
 * Each line of the output contains the result <tt>n<sup>p</sup></tt>, if both <tt>n</tt> and <tt>p</tt> are positive. If either <tt>n</tt> or
 * <tt>p</tt> is negative, the output contains <tt>"n and p should be non-negative"</tt>. If both <tt>n</tt> and <tt>p</tt> are zero, the output
 * contains <tt>"n and p should not be zero."</tt>. This is printed by the locked stub code in the editor.
 * <h3>Sample Input 0</h3>
 * <pre>
 * 3 5
 * 2 4
 * 0 0
 * -1 -2
 * -1 3
 * </pre>
 * <h3>Sample Output 0</h3>
 * <pre>
 * 243
 * 16
 * java.lang.Exception: n and p should not be zero.
 * java.lang.Exception: n or p should not be negative.
 * java.lang.Exception: n or p should not be negative.
 * </pre>
 * <h3>Explanation 0</h3>
 * <ul>
 * <li>In the first two cases, both <tt>n</tt> and <tt>p</tt> are postive. So, the power function returns the answer correctly.</li>
 * <li>In the third case, both <tt>n</tt> and <tt>p</tt> are zero. So, the exception, <tt>"n and p should not be zero."</tt>, is printed.</li>
 * <li>In the last two cases, at least one out of <tt>n</tt> and <tt>p</tt> is negative. So, the exception, <tt>"n or p should not be negative."</tt>,
 * is printed for these two cases.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.09.2017
 */
public class JavaExceptionHandling {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String... args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    static class MyCalculator {
        long power(int n, int p) throws Exception {
            if (n < 0 || p < 0)
                throw new Exception("n or p should not be negative.");
            if (n == 0 && p == 0)
                throw new Exception("n and p should not be zero.");

            return (long)Math.pow(n, p);
        }
    }
}


