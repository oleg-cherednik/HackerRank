import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.07.2018
 */
public class Solution {

    static int maximizingXor(int l, int r) {
        int res = 0;

        for (int i = l; i <= r; i++)
            for (int j = i; j <= r; j++)
                res = Math.max(res, i ^ j);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
