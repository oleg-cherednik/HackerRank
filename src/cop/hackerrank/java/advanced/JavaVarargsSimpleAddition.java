package cop.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Java Varargs - Simple Addition</h1>
 * You are given a class <tt>Solution</tt> and its <tt>main</tt> method in the editor.<br>
 * Your task is to create the class <tt>Add</tt> and the required methods so that the code prints the <tt>sum</tt> of the <tt>numbers</tt> passed to
 * the function <tt>add</tt>.
 * <p>
 * <b>Note:</b> Your <tt>add</tt> method in the <tt>Add</tt> class must print the <tt>sum</tt> as given in the <tt>Sample Output</tt>
 * <h3>Input Format</h3>
 * There are six lines of input, each containing an integer.
 * <h3>Output Format</h3>
 * There will be only four lines of output. Each line contains the sum of the <tt>integers</tt> passed as the parameters to <tt>add</tt> in the
 * <tt>main</tt> method.
 * <h3>Sample Input</h3>
 * <pre>
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 1+2=3
 * 1+2+3=6
 * 1+2+3+4+5=15
 * 1+2+3+4+5+6=21
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.09.2017
 */
public class JavaVarargsSimpleAddition {
    static class Add {
        public void add(int... arr) {
            int sum = 0;
            StringBuilder buf = new StringBuilder();

            for (int val : arr) {
                if (buf.length() > 0)
                    buf.append('+');
                buf.append(val);

                sum += val;
            }

            buf.append('=').append(sum);
            System.out.println(buf);
        }
    }

    public static void main(String... args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());

            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);

            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;

            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }

                set.add(methods[i].getName());
            }

            if (overload)
                throw new Exception("Overloading not allowed");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
