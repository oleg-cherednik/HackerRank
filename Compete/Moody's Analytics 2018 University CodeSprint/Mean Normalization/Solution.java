import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {
    public static double normalizeMean(int[][] stocks, long[] sums) {
        double res = Double.MAX_VALUE;

        for (int i = 0; i < stocks.length; i++) {
            double mean = (double)sums[i] / stocks[i].length;
            res = Math.min(res, diffSum(stocks, res, mean));
        }

        return res;
    }

    private static double diffSum(int[][] stocks, double cur, double mean) {
        double res = 0;

        for (int[] stock : stocks) {
            for (int price : stock) {
                res += Math.abs(price - mean);

                if (res > cur)
                    return cur;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[][] stocks = new int[n][];
            long[] sums = new long[n];

            for (int i = 0, start = 0; i < n; i++, start = 0) {
                int m = Integer.parseInt(in.readLine());
                String str = in.readLine();

                stocks[i] = new int[m];
                long sum = 0;

                for (int j = 0; j < m; j++) {
                    int end = str.indexOf(' ', start);
                    int price = Integer.parseInt(str.substring(start, end < 0 ? str.length() : end));
                    stocks[i][j] = price;
                    sum += price;
                    start = end + 1;
                }

                sums[i] = sum;
            }

            System.out.format(Locale.US, "%.12f", normalizeMean(stocks, sums));
        }
    }

}
