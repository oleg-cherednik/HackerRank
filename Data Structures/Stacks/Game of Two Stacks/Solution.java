import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 09.04.2018
 */
public class Solution {

    private static class InitData {

        private int score;
        private int sum;

        public static InitData calc(int[] arr, int x) {
            InitData initData = new InitData();

            for (int val : arr) {
                if (initData.sum + val > x)
                    break;
                initData.score++;
                initData.sum += val;
            }

            return initData;
        }
    }

    static int twoStacks(int x, int[] a, int[] b) {
        InitData initA = InitData.calc(a, x);
        InitData initB = InitData.calc(b, x);

        if (initA.sum + initB.sum <= x)
            return initA.score + initB.score;

        return score(x, 0, 0, a, b, 0, 0);
    }

    private static int score(int x, int sum, int score, int[] a, int[] b, int i, int j) {

        int res = 0;

        int aa = i < a.length ? a[i] : Integer.MAX_VALUE;
        int bb = j < b.length ? b[j] : Integer.MAX_VALUE;

        if (i < a.length && aa <= bb && sum + a[i] <= x)
            res = Math.max(res, score(x, sum + a[i], 1, a, b, i + 1, j));
        else if (j < b.length && bb <= aa && sum + b[j] <= x)
            res = Math.max(res, score(x, sum + b[j], 1, a, b, i, j + 1));

        return score + res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            System.out.println(result);
        }
    }
}
