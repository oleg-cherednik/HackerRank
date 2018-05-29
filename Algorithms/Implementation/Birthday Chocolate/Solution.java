import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    static int solve(int n, int[] s, int d, int m) {
        int res = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < s.length; i++) {
            sum += s[i];

            if (count < m)
                count++;
            else
                sum -= s[i - m];

            if (count == m && sum == d)
                res++;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] s = new int[n];

        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s[i] = sItem;
        }

        String[] dm = scanner.nextLine().split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = solve(n, s, d, m);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
