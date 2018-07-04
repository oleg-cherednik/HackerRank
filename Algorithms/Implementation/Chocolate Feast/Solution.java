import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.07.2018
 */
public class Solution {

    static int chocolateFeast(int n, int c, int m) {
        int total = n / c;
        int w = total;

        while (w >= m) {
            total += w / m;
            w = w / m + w % m;
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
