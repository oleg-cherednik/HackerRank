import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double A = scan.nextDouble();
            double B = scan.nextDouble();

            double dailyCostA = 160 + 40 * (A + (A * A));
            double dailyCostB = 128 + 40 * (B + (B * B));

            System.out.format(Locale.US, "%.3f\n", dailyCostA);
            System.out.format(Locale.US, "%.3f\n", dailyCostB);
        }
    }
}
