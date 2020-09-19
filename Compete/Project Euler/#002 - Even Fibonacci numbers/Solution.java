import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    private static final Set<Long> EVEN_FIBONACCI = new TreeSet<>();
    private static long f0 = 0;
    private static long f1 = 1;

    static long findEvenFibonacciSum(long n) {
        while (n > f1) {
            long num = f0 + f1;

            if (num % 2 == 0)
                EVEN_FIBONACCI.add(num);

            f0 = f1;
            f1 = num;
        }

        long sum = 0;

        for (long num : EVEN_FIBONACCI) {
            if (num > n)
                break;
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(findEvenFibonacciSum(n));
        }
    }

}
