import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double ans = 0.0;

            for (int i = 3; i <= 6; i++)
                ans += fact(6) / (fact(i) * fact(6 - i)) * Math.pow(a / (a + b), i) * Math.pow(b / (a + b), 6 - i);

            System.out.format("%.3f\n", ans);
        }
    }

    private static long fact(int n) {
        return n == 0 || n == 1 ? 1 : n * fact(n - 1);
    }
}
