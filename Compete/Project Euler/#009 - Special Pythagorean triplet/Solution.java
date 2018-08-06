import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 06.08.2018
 */
public class Solution {

    private static int findMaxPythagoreanTriplet(int n) {
        int max = -1;

        for (int a = 1; a <= n / 3; a++) {
            int b = (2 * a * n - n * n) / (2 * a - 2 * n);
            int c = n - b - a;

            if (a * a + b * b == c * c && a < b && b < c)
                max = a * b * c;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(findMaxPythagoreanTriplet(n));
        }
    }

}
