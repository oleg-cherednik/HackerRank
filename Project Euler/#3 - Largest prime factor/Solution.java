import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    static long largestPrime(long n) {
        long res = n;

        while (true) {
            long div = getDiv(res);

            if (div == res)
                break;

            res /= div;
        }

        return res;
    }

    private static long getDiv(long val) {
        if (val < 2)
            return val;

        int sqrt = (int)Math.sqrt(val);

        for (int i = 2; i <= sqrt; i++)
            if (val % i == 0)
                return i;

        return val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(largestPrime(n));
        }
    }

}
