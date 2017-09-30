import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.09.2017
 */
public class Solution {
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
