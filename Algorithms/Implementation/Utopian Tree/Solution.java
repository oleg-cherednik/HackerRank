import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int utopianTree(int n) {
        int height = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                height *= 2;
            else
                height++;
        }

        return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
