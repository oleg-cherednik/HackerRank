import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.07.2018
 */
public class Solution {

    static int jumpingOnClouds(int[] c) {
        int res = 0;
        int i = 0;

        while (i < c.length - 1) {
            res++;
            i++;

            if (i + 1 < c.length) {
                i++;

                if (c[i] == 1) {
                    res++;
                    i++;
                }
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
