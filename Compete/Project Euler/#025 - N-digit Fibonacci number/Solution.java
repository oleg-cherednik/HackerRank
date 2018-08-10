import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    static long findFibonacci(int N) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int i = 3;

        for (; i <= 5000; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;

            if (c.toString().length() == N)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(findFibonacci(scan.nextInt()));
        }
    }
}
