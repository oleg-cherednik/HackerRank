import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {
    public static double normalizeMean(int[][] stocks) {
        double res = Double.MAX_VALUE;

        for (int i = 0; i < stocks.length; i++)
            res = Math.min(res, diffSum(stocks, mean(stocks[i])));

        return res;
    }

    private static double mean(int[] prices) {
        int sum = 0;

        for (int price : prices)
            sum += price;

        return (double)sum / prices.length;
    }

    private static double diffSum(int[][] stocks, double mean) {
        double res = 0;

        for (int[] stock : stocks)
            for (int price : stock)
                res += Math.abs(price - mean);

        return res;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[][] stocks = new int[n][];

            for (int i = 0; i < n; i++) {
                int m = scan.nextInt();
                stocks[i] = new int[m];

                for (int j = 0; j < m; j++)
                    stocks[i][j] = scan.nextInt();
            }

            System.out.format(Locale.US, "%.12f", normalizeMean(stocks));

        }
    }

}
