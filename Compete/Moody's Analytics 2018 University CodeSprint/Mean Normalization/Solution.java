import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {
    public static double normalizeMean(int[][] stocks, long[] sums) {
        double res = Double.MAX_VALUE;

        Map<Double, Integer> map = new TreeMap<>();

        for (int i = 0; i < sums.length; i++)
            map.put((double)sums[i] / stocks[i].length, i);

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            double mean = entry.getKey();
            double cur = diffSum(stocks, mean);

            if (cur > res)
                return res;

            res = cur;
        }

        return res;
    }

    private static double diffSum(int[][] stocks, double mean) {
        double res = 0;

        for (int[] stock : stocks)
            for (int price : stock)
                res += Math.abs(price - mean);

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
