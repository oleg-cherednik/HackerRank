import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        int m = scan.nextInt();
        int n = scan.nextInt();
        double[] Y = new double[n];
        double[][] X = new double[n][m + 1];

        for (int i = 0; i < n; i++) {
            X[i][0] = 1;

            for (int j = 0; j < m; j++)
                X[i][j + 1] = scan.nextDouble();

            Y[i] = scan.nextDouble();
        }

        double[] b = solve(mult(transpose(X), X), mult(transpose(X), Y), 1e-8);

        int q = scan.nextInt();
        double[] obs = new double[m + 1];

        for (int i = 0; i < q; i++) {
            obs[0] = 1;

            for (int j = 0; j < m; j++)
                obs[j + 1] = scan.nextDouble();

            double res = 0;

            for (int j = 0; j < m + 1; j++)
                res += b[j] * obs[j];

            System.out.format(Locale.US, "%.9f\n", res);
        }
    }

    private static double[] solve(double[][] A, double y[], double tol) {
        double[] z = new double[y.length];

        for (int i = 0; i < y.length; i++)
            z[i] = Math.random() - 0.5;

        for (int i = 0; i < 10000; i++) {
            double epsilon = 0;

            for (int j = 0; j < y.length; j++) {
                double tmp = z[j];
                z[j] = 0;

                for (int k = 0; k < y.length; k++)
                    if (k != j)
                        z[j] += A[j][k] * z[k];

                z[j] = (y[j] - z[j]) / A[j][j];
                epsilon += Math.abs(tmp - z[j]);
            }

            if (epsilon < tol)
                break;
        }

        return z;
    }

    private static double[][] transpose(double[][] X) {
        double[][] xt = new double[X[0].length][X.length];

        for (int i = 0; i < X.length; i++)
            for (int j = 0; j < X[0].length; j++)
                xt[j][i] = X[i][j];

        return xt;
    }

    private static double[][] mult(double[][] X, double[][] Y) {
        int p = Y[0].length;
        double[][] A = new double[X.length][p];

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < p; j++) {
                double tmp = 0;

                for (int k = 0; k < X[0].length; k++)
                    tmp += X[i][k] * Y[k][j];

                A[i][j] = tmp;
            }
        }

        return A;
    }

    private static double[] mult(double[][] X, double[] Y) {
        double[] z = new double[X.length];

        for (int i = 0; i < X.length; i++) {
            double tmp = 0;

            for (int k = 0; k < Y.length; k++)
                tmp += X[i][k] * Y[k];

            z[i] = tmp;
        }

        return z;
    }

}

