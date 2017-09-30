import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.09.2017
 */
public class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int k = 1;
            int res = a;

            for (int j = 0; j < n; j++) {
                res += k * b;
                k *= 2;
                System.out.print(String.format("%d ", res));
            }

            System.out.println();

        }
        in.close();
    }
}
