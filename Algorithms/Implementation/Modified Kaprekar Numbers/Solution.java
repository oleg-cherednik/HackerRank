import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static void kaprekarNumbers(int p, int q) {


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
