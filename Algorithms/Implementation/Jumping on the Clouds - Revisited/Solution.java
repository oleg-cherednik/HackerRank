import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.06.2018
 */
public class Solution {

    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int i = 0;

        do {
            i = (i + k) % c.length;
            e -= c[i] == 0 ? 1 : 3;
        } while (e > 0 && i != 0);

        return e;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
