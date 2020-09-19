import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 06.08.2018
 */
public class Solution {

    public static long largestProduct(String num, int k) {
        long max = 0;

        for (int i = 0; i < num.length() - k; i++) {
            long cur = 1;

            for (int j = 0; j < k && cur != 0; j++)
                cur *= num.charAt(i + j) - '0';

            max = Math.max(max, cur);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            System.out.println(largestProduct(num, k));
        }
    }

}
