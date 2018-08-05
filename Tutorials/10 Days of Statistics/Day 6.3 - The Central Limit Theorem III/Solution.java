import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            scan.useLocale(Locale.US);
            int n = scan.nextInt();
            int mean = scan.nextInt();
            int std = scan.nextInt();
            scan.nextDouble();
            double zScore = scan.nextDouble();

            double marginOfError = zScore * std / Math.sqrt(n);

            System.out.format(Locale.US, "%.2f\n", mean - marginOfError);
            System.out.format(Locale.US, "%.2f\n", mean + marginOfError);
        }
    }

}

