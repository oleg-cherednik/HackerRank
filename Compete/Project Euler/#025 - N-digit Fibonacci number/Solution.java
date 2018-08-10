import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.08.2018
 */
public class Solution {

    private static final double GOLDEN_RATION_PHI = 1.61803;

    static long findFibonacci(int N) {
        return (long)Math.ceil((Math.log(10) * (N - 1) + Math.log(5) / 2) / Math.log(GOLDEN_RATION_PHI));
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(findFibonacci(scan.nextInt()));
        }
    }
}
