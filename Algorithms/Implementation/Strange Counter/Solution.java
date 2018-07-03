import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.07.2018
 */
public class Solution {

static long strangeCounter(long t) {
    long pow = 2;
    long s;

    while ((s = 3 * pow - 3) < t) {
        pow *= 2;
    }

    return s - t + 1;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
