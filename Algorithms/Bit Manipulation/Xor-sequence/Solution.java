import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.07.2018
 */
public class Solution {

    static long xorSequence(long l, long r) {
        return g(r) ^ g(l - 1);
    }

    private static long g(long x) {
        long a = x % 8;
        if (a == 0 || a == 1)
            return x;
        if (a == 2 || a == 3)
            return 2;
        if (a == 4 || a == 5)
            return x + 2;
        if (a == 6 || a == 7)
            return 0;
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            long l = Long.parseLong(lr[0]);

            long r = Long.parseLong(lr[1]);

            long result = xorSequence(l, r);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
