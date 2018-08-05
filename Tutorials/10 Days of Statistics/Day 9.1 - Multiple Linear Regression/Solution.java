import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        double[] Y = new double[n];
        double[][] X = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            X[i][0] = 1;
            for (int j = 0; j < m; j++) {
                X[i][j + 1] = scanner.nextDouble();
            }
            Y[i] = scanner.nextDouble();
        }
        double[] b = solve(mult(transpose(X), X), mult(transpose(X), Y), 1e-8);
        ///
        int q = scanner.nextInt();
        double[] obs = new double[m + 1];
        double tmp = 0;
        for (int i = 0; i < q; i++) {
            obs[0] = 1;
            for (int j = 0; j < m; j++) {
                obs[j + 1] = scanner.nextDouble();
            }
            tmp = 0;
            for (int j = 0; j < m + 1; j++) {
                tmp += b[j] * obs[j];
            }
            System.out.format("%.9f\n", tmp);
        }
    }

    public static double[][] transpose(double[][] X) {
        int n = X.length;
        int m = X[0].length;
        double[][] XT = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                XT[j][i] = X[i][j];
            }
        }
        return XT;
    }

    /**
     * Matrix times matrix
     */
    public static double[][] mult(double[][] X, double[][] Y) {
        int n = X.length;
        int m = X[0].length;
        int mCheck = Y.length;
        int p = Y[0].length;
        double[][] A = new double[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                double tmp = 0;
                for (int k = 0; k < m; k++) {
                    tmp += X[i][k] * Y[k][j];
                }
                A[i][j] = tmp;
            }
        }
        return A;
    }

    /**
     * Matrix times vector
     */
    public static double[] mult(double[][] X, double[] Y) {
        int n = X.length;
        int m = X[0].length;
        int p = Y.length;
        double[] z = new double[n];
        for (int i = 0; i < n; i++) {
            double tmp = 0;
            for (int k = 0; k < p; k++) {
                tmp += X[i][k] * Y[k];
            }
            z[i] = tmp;
        }
        return (z);
    }

    /**
     * Solves the linear system A z=y using Gauss-Seidel iteration. This implementation is not robust to
     * scaling and convergence issues.
     */
    public static double[] solve(double[][] A, double y[], double tol) {
        int n = y.length;
        double[] z = new double[n];
        for (int i = 0; i < n; i++) {
            z[i] = Math.random() - 0.5;//Random initialisation
        }
        double epsilon = 0;
        double curr = 0;
        for (int k = 0; k < 10000; k++) {
            //z=mult(A,z);
            epsilon = 0;
            for (int i = 0; i < n; i++) {
                curr = z[i];
                z[i] = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        z[i] += A[i][j] * z[j];
                    }
                }
                //z[i]+=-y[i];
                z[i] = (y[i] - z[i]) / A[i][i];
                epsilon += Math.abs(curr - z[i]);
            }
            if (epsilon < tol) {
                //System.out.println("converged at k="+k);
                break;
            }
        }
        return z;
    }

}

