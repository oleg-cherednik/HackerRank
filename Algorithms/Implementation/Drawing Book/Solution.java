import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 30.05.2018
 */
public class Solution {

    static int pageCount(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
