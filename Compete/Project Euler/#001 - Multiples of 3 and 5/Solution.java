import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static long findSum(long n) {
        return sum(3, n) + sum(5, n) - sum(15, n);
    }

    private static long sum(int a1, long n) {
        long p = (n - 1) / a1;
        return (a1 * p * (p + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = Long.parseLong(in.next());
            System.out.println(findSum(n));
        }
    }

//    public static void main(String... args) {
//        System.out.println(findSum(1_000));  // 233168
//    }

}
