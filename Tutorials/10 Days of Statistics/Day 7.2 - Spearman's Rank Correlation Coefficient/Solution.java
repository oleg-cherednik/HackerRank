import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            scan.useLocale(Locale.US);

            int n = scan.nextInt();
            double[] x = new double[n];
            double[] y = new double[n];

            TreeSet<Double> data = new TreeSet<>();

            for (int i = 0; i < n; i++)
                data.add(x[i] = scan.nextDouble());

            for (int i = 0; i < n; i++) {
                x[i] = data.headSet(x[i]).size() + 1;
                y[i] = scan.nextDouble();
            }

            data.clear();

            for (int i = 0; i < n; i++)
                data.add(y[i]);

            for (int i = 0; i < n; i++)
                y[i] = data.headSet(y[i]).size() + 1;

            int sigma = 0;

            for (int i = 0; i < n; i++)
                sigma += Math.pow((int)x[i] - (int)y[i], 2);

            System.out.format(Locale.US, "%.3f\n", 1 - 6.0 * sigma / (n * (n * n - 1)));
        }
    }

}

