import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numerator = scan.nextInt();
        int denominator = scan.nextInt();
        int n = scan.nextInt();
        double p = numerator / denominator;
        System.out.format(Locale.US, "%.3f\n", Math.pow(1 - p, n - 1) * p);
    }
}
