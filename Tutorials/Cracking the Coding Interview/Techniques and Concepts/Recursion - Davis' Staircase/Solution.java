import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    private static final int[] ARR = new int[37];

    static {
        Arrays.fill(ARR, -1);
        ARR[0] = 0;
        ARR[1] = 1;
        ARR[2] = 2;
        ARR[3] = 4;
    }

    private static int maxWays(int n) {
        if (ARR[n] == -1)
            ARR[n] = maxWays(n - 1) + maxWays(n - 2) + maxWays(n - 3);
        return ARR[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println(maxWays(n));
        }

        scanner.close();
    }

}
