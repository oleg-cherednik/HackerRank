package cop.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * <h1>Prime Checker</h1>
 * You are given a class <tt>Solution</tt> and its <tt>main</tt> method in the editor. Your task is to create a class <tt>Prime</tt>. The class
 * <tt>Prime</tt> should contain a single method <tt>checkPrime</tt>.
 * <p>
 * The locked code in the editor will call the <tt>checkPrime</tt> method with one or more integer arguments. You should write the
 * <tt>checkPrime</tt>
 * method in such a way that the code prints only the <a href="https://en.wikipedia.org/wiki/Prime_number">prime numbers</a>.
 * <p>
 * Please read the code given in the editor carefully. Also please do not use method overloading!
 * <p>
 * <b>Note:</b> You may get a compile time error in this problem due to the statement below:
 * <pre>
 * BufferedReader br=new BufferedReader(new InputStreamReader(in));
 * </pre>
 * This was added intentionally, and you have to figure out a way to get rid of the error.
 * <h3>Input Format</h3>
 * There are only five lines of input, each containing one integer.
 * <h3>Output Format</h3>
 * There will be only four lines of output. Each line contains only prime numbers depending upon the parameters passed to <tt>checkPrime</tt> in the
 * <tt>main</tt> method of the class <tt>Solution</tt>. In case there is no prime number, then a blank line should be printed.
 * <h3>Sample Input</h3>
 * <pre>
 * 2
 * 1
 * 3
 * 4
 * 5
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 2
 * 2
 * 2 3
 * 2 3 5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class PrimeChecker {
    static class Prime {
        public void checkPrime(int... vals) {
            boolean space = false;

            for (int val : vals) {
                if (!isPrime(val))
                    continue;
                if (space)
                    System.out.print(' ');
                System.out.print(val);
                space = true;
            }

            System.out.println();
        }

        private static boolean isPrime(int val) {
            if (val < 2)
                return false;

            int sqrt = (int)Math.sqrt(val);

            for (int i = 2; i <= sqrt; i++)
                if (val % i == 0)
                    return false;

            return true;
        }
    }

    public static void main(String... args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
