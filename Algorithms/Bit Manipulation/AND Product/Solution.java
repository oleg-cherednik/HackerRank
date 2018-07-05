import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.07.2018
 */
public class Solution {

    static long andProduct(long a, long b) {
        long res = a;

        for (long i = a + 1; i <= b; i++)
            res &= i;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] ab = scanner.nextLine().split(" ");

            long a = Long.parseLong(ab[0]);

            long b = Long.parseLong(ab[1]);

            long result = andProduct(a, b);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
