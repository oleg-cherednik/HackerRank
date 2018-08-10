import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    private static int numberOfDigits(int n) {
        if (n == 1)
            return 1;

        double ans = (n * Math.log10(1.6180339887498948)) - ((Math.log10(5)) / 2);
        return (int)Math.ceil(ans);
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int j = 0; j < T; j++) {
                int n = scan.nextInt();
                int low = 0;
                int high = 25000;
                int mid = 0, mid_n = 0;

                while (low < high) {
                    mid = (low + high) / 2;
                    mid_n = numberOfDigits(mid);

                    if (mid_n >= n)
                        high = mid;
                    else
                        low = mid + 1;

                }


                System.out.println((low + high) / 2);
            }
        }
    }

}
