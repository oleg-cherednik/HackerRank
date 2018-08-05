import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 21.05.2018
 */
public class Solution {

    static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
