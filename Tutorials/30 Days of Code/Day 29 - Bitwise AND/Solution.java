import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.06.2018
 */
public class Solution {

    public static int bitwiseAnd(int n, int k) {
        int res = 0;

        for (int i = 1; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if ((i & j) < k)
                    res = Math.max(res, i & j);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            System.out.println(bitwiseAnd(n, k));
        }

        scanner.close();
    }

}

