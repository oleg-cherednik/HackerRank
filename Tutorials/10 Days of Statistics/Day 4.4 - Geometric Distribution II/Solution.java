import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double p = (double)scan.nextInt() / scan.nextInt();
            int n = scan.nextInt();

            double q = 1 - p;
            double prob = 0;

            for (int i = 0; i < n; i++)
                prob += Math.pow(q, i) * p;

            System.out.printf(Locale.US, "%.3f", prob);
        }
    }
}
