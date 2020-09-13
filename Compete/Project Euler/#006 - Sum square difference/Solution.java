import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 19.07.2018
 */
public class Solution {

    private static final Map<Integer, Long> SQUARE = new HashMap<>();
    private static final Map<Integer, Long> SUM = new HashMap<>();

    static {
        long sum = 0;
        long square = 0;

        for (int i = 1; i <= 10000; i++) {
            sum += i;
            square += i * i;
            SQUARE.put(i, square);
            SUM.put(i, sum * sum);
        }
    }

    static long sumSquareDifference(int n) {
        return Math.abs(SQUARE.get(n) - SUM.get(n));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(sumSquareDifference(n));
        }
    }

//    public static void main(String... args) {
//        System.out.println(sumSquareDifference(100));   // 25164150
//    }

}
