package cop.hackerrank.java.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Java Exception Handling (Try-catch)</h1>
 * Exception handling is the process of responding to the occurrence, during computation, of exceptions – anomalous or exceptional conditions
 * requiring special processing – often changing the normal flow of program execution. (Wikipedia)<br>
 * <br>
 * <hr>
 * <br>
 * Java has built-in mechanism to handle exceptions. Using the <tt>try</tt> statement we can test a block of code for errors. The <tt>catch</tt>
 * block
 * contains the code that says what to do if exception occurs.<br>
 * <br>
 * This problem will test your knowledge on try-catch block.<br>
 * <br>
 * You will be given two integers <tt>x</tt> and <tt>y</tt> as input, you have to compute <tt>x / y</tt>. If <tt>x</tt> and <tt>y</tt> are not 32 bit
 * signed integers or if <tt>y</tt> is zero, exception will occur and you have to report it. Read sample Input/Output to know what to report in case
 * of exceptions.
 * <h3>Sample Input 0:</h3>
 * <pre>
 * 10
 * 3
 * </pre>
 * <h3>Sample Output 0:</h3>
 * <pre>
 * 3
 * </pre>
 * <h3>Sample Input 1:</h3>
 * <pre>
 * 10
 * Hello
 * </pre>
 * <h3>Sample Output 1:</h3>
 * <pre>
 * java.util.InputMismatchException
 * </pre>
 * <h3>Sample Input 2:</h3>
 * <pre>
 * 10
 * 0
 * </pre>
 * <h3>Sample Output 2:</h3>
 * <pre>
 * java.lang.ArithmeticException: / by zero
 * </pre>
 * <h3>Sample Input 3:</h3>
 * <pre>
 * 23.323
 * 0
 * </pre>
 * <h3>Sample Output 3:</h3>
 * <pre>
 * java.util.InputMismatchException
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 19.09.2017
 */
public class JavaExceptionHandlingTryCatch {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);

        try {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x / y);
        } catch(ArithmeticException e) {
            System.out.println(e);
        } catch(InputMismatchException e) {
            System.out.println(e.getClass().getName());
        }
    }
}
