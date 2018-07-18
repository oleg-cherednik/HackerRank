import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static long findSum(long n) {
        long sum3 = sum(3, 3, (n - 1) / 3);
        long sum5 = sum(5, 5, (n - 1) / 5);
        long sum15 = sum(15, 15, (n - 1) / 15);

        return sum3 + sum5 - sum15;
    }

    private static long sum(int a1, int d, long n) {
        return (a1 * n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = Long.parseLong(in.next());
            System.out.println(findSum(n));
        }
    }

}
