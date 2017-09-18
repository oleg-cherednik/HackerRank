package cop.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * <h1>Java Stdin and Stdout I</h1>
 * Most HackerRank challenges require you to read input from stdin (standard input) and write output to stdout (standard output).<br>
 * One popular way to read input from stdin is by using the Scanner class and specifying the <tt>Input Stream</tt> as <tt>System.in</tt>. For example:
 * <pre>
 * Scanner scanner = new Scanner(System.in);
 * String myString = scanner.next();
 * int myInt = scanner.nextInt();
 * scanner.close();
 *
 * System.out.println("myString is: " + myString);
 * System.out.println("myInt is: " + myInt);
 * </pre>
 * The code above creates a Scanner object named <tt>scanner</tt> and uses it to read a String and an int. It then closes the Scanner object because
 * there is no more input to read, and prints to stdout using <tt>System.out.println(String)</tt>. So, if our input is:
 * <pre>
 * Hi 5
 * </pre>
 * Our code will print:
 * <pre>
 * myString is: Hi
 * myInt is: 5
 * </pre>
 * Alternatively, you can use the BufferedReader class.
 * <h3>Task</h3>
 * In this challenge, you must read 3 integers from stdin and then print them to stdout. Each integer must be printed on a new line. To make the
 * problem a little easier, a portion of the code is provided for you in the editor below.
 * <h3>Input Format</h3>
 * There are 3 lines of input, and each line contains a single integer.
 * <h3>Sample Input</h3>
 * <pre>
 * 42
 * 100
 * 125
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 42
 * 100
 * 125
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 10.09.2017
 */
public class JavaStdinAndStdout1 {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
