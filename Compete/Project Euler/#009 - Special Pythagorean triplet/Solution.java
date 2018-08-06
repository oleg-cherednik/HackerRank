import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 06.08.2018
 */
public class Solution {

    private static int findMaxPythagoreanTriplet(int n) {
        if (n < 3)
            return -1;

        int max = -1;

        for (int c = Math.max(1, n - 1); c >= 1; c--) {
            int c2 = c * c;

            for (int b = Math.max(1, c - 1); b >= 1; b--) {
                int b2 = b * b;
                int a2 = c2 - b2;

                if (a2 < b2) {
                    int a = (int)Math.sqrt(a2);

                    if (a * a == a2 && a + b + c == n)
                        max = Math.max(max, a * b * c);
                }
            }
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
