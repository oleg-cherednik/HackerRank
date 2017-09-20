package cop.hackerrank.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <h1>Java BigDecimal</h1>
 * Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!<br>
 * <br>
 * Given an array, <tt>s</tt>, of <tt>n</tt> real number strings, sort them in descending order — but wait, there's more! Each number must be printed
 * in the exact same format as it was read from stdin, meaning that .1 is printed as .1, and 0.1 is printed as 0.1. If two numbers represent
 * numerically equivalent values (e.g., .1 ≡ 0.1 ), then they must be listed in the same order as they were received as input).<br>
 * <br>
 * Complete the code in the unlocked section of the editor below. You must rearrange array <tt>s</tt>'s elements according to the instructions above.
 * <h3>Input Format</h3>
 * The first line consists of a single integer, <tt>n</tt>, denoting the number of integer strings.<br>
 * Each line <tt>i</tt> of the <tt>n</tt> subsequent lines contains a real number denoting the value of <tt>s</tt>.
 * <tt>Constraints</tt>
 * <ul>
 * <li>1 <= n <= 200</li>
 * <li>Each <tt>s<sub>i</sub></tt> has <tt>at most</tt> 300 digits.</li>
 * </ul>
 * <h3>Output Format</h3>
 * Locked stub code in the editor will print the contents of array <tt>s</tt> to stdout. You are only responsible for reordering the array's elements.
 * <h3>Sample Input</h3>
 * <pre>
 * 9
 * -100
 * 50
 * 0
 * 56.6
 * 90
 * 0.12
 * .12
 * 02.34
 * 000.000
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 90
 * 56.6
 * 50
 * 02.34
 * 0.12
 * .12
 * 0
 * 000.000
 * -100
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaBigDecimal {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];

        for (int i = 0; i < n; i++)
            s[i] = sc.next();

        sc.close();

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a == null)
                    return 1;
                if (b == null)
                    return -1;
                return new BigDecimal(b).compareTo(new BigDecimal(a));
            }
        });

        for (int i = 0; i < n; i++)
            System.out.println(s[i]);
    }
}
