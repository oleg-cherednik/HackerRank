import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.05.2018
 */
public class Solution {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */

        /* Print the sum of the double variables on a new line. */

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        int ii = scan.nextInt();
        double dd = scan.nextDouble();
        String ss = scan.next() + scan.nextLine();

        System.out.println(i + ii);
        System.out.println(d + dd);
        System.out.println(s + ss);

        scan.close();
    }
}
