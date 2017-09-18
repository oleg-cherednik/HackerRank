package cop.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * <h1>Java If-Else</h1>
 * In this challenge, we test your knowledge of using if-else conditional statements to automate decision-making processes. An if-else statement has
 * the following logical flow:
 * <pre>
 * <img src="image.png"/>
 * </pre>
 * <h3>Task</h3>
 * Given an integer, n  perform the following conditional actions:
 * <ul>
 * <li>If n is odd, print <tt>Weird</tt></li>
 * <li>If n is even and in the inclusive range of 2 to 5, print <tt>Not Weird</tt></li>
 * <li>If n is even and in the inclusive range of 6 to 20, print <tt>Weird</tt></li>
 * <li>If n is even and greater than 20, print <tt>Not Weird</tt></li>
 * </ul>
 * Complete the stub code provided in your editor to print whether or not n is weird.
 * <h3>Input Format</h3>
 * A single line containing a positive integer, n.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= n <= 100</li>
 * </ul>
 * <h3>Output Format</h3>
 * Print <tt>Weird</tt> if the number is weird; otherwise, print <tt>Not Weird</tt>.
 * <h3>Sample Input 0</h3>
 * <pre>
 * 3
 * </pre>
 * <h3>Sample Output 0</h3>
 * <pre>
 * Weird
 * </pre>
 * <h3>Sample Input 1</h3>
 * <pre>
 * 24
 * </pre>
 * <h3>Sample Output 1</h3>
 * <pre>
 * Not Weird
 * </pre>
 * <h3>Explanation</h3>
 * <tt>Sample Case 0:</tt><br>
 * n is odd and odd numbers are weird, so we print <tt>Weird</tt>.<br>
 * <tt>Sample Case 1:</tt><br>
 * n > 20 and n is even, so it isn't weird. Thus, we print <tt>Not Weird</tt>.
 *
 * @author Oleg Cherednik
 * @since 11.09.2017
 */
public class JavaIfElse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";
        if (n % 2 == 1) {
            ans = "Weird";
        } else {
            if (n >= 2 && n <= 5)
                System.out.println("Not Weird");
            else if (n >= 6 && n <= 20)
                System.out.println("Weird");
            else
                System.out.println("Not Weird");
        }
        System.out.println(ans);
    }
}
