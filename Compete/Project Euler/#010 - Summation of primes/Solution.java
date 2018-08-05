import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    private static final long[] SUM = new long[1000001];

    static {
        long sum = 0;

        for (int i = 0; i < SUM.length; i++) {
            if (isPrime(i))
                sum += i;

            SUM[i] = sum;
        }
    }

    static long sumPrimes(int n) {
        return SUM[n];
    }

    private static boolean isPrime(long val) {
        if (val < 2)
            return false;

        int sqrt = (int)Math.sqrt(val);

        for (int i = 2; i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(sumPrimes(n));
        }
    }

}
