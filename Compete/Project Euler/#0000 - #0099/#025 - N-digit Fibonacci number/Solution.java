import java.util.Scanner;
import java.util.function.IntFunction;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    private static final double GOLDEN_RATIO_PHI = (1 + Math.sqrt(5)) / 2;
    private static final double LOG_10_PHI = Math.log10(GOLDEN_RATIO_PHI);
    private static final double LOG_10_5_DIV_2 = Math.log10(5) / 2;
    private static final IntFunction<Integer> DIGIT_NUMBER = n -> n == 1 ? 1 : (int)Math.ceil(n * LOG_10_PHI - LOG_10_5_DIV_2);

    public static int numberOfDigits(int N) {
        int low = 0;
        int high = 25000;

        while (low < high) {
            int mid = (low + high) / 2;

            if (DIGIT_NUMBER.apply(mid) >= N)
                high = mid;
            else
                low = mid + 1;
        }

        return (low + high) / 2;
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(numberOfDigits(scan.nextInt()));
    }

}
