package cop.hackerrank.java.objectorientedprogramming;

/**
 * <h1>Java Inheritance 2</h1>
 * Write the following code in your editor below:
 * <ol>
 * <li>A class named <tt>Arithmetic</tt> with a method named <tt>add</tt> that takes 2 integers as parameters and returns an integer denoting their
 * sum.</li>
 * <li>A class named <tt>Adder</tt> that inherits from a superclass named <tt>Arithmetic</tt>.</li>
 * </ol>
 * Your classes should not be <tt>public</tt>.
 * <h3>Input Format</h3>
 * You are not responsible for reading any input from stdin; a locked code stub will test your submission by calling the <tt>add</tt> method on an
 * <tt>Adder</tt> object and passing it 2 integer parameters.
 * <h3>Output Format</h3>
 * You are not responsible for printing anything to stdout. Your <tt>add</tt> method must return the sum of its parameters.
 * <h3>Sample Output</h3>
 * The <tt>main</tt> method in the <tt>Solution</tt> class above should print the following:
 * <pre>
 * My superclass is: Arithmetic
 * 42 13 20
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 21.09.2017
 */
public class JavaInheritance2 {
    static class Arithmetic {
    }

    static class Adder extends Arithmetic {
        int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String... args) {
        // Create a new Adder object
        Adder a = new Adder();

        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.println(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
    }
}
