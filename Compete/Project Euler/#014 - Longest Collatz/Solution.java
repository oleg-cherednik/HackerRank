import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.08.2018
 */
public class Solution {

    private static final int[] STEPS = new int[5_000_001];
    private static final int[] RES = new int[5_000_001];

    static {
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 1; i < STEPS.length; i++) {
            if (STEPS[i] > 0)
                continue;

            map.clear();

            long j = i;
            int steps = 0;

            while (j != 1) {
                if (j < STEPS.length && STEPS[(int)j] > 0) {
                    steps += STEPS[(int)j];
                    break;
                }

                j = j % 2 == 0 ? j / 2 : (3 * j + 1);
                steps++;
                map.put(j, steps);
            }

            STEPS[i] = steps;

            for (Map.Entry<Long, Integer> entry : map.entrySet())
                if (entry.getKey() < STEPS.length && STEPS[entry.getKey().intValue()] == 0)
                    STEPS[entry.getKey().intValue()] = steps - entry.getValue();
        }

        for (int i = 0, j = 0; i < STEPS.length; i++)
            RES[i] = STEPS[i] >= STEPS[j] ? j = i : j;
    }

    static int longestCollatz(int N) {
        return RES[N];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(longestCollatz(scan.nextInt()));
    }

//    public static void main(String... args) {
//        System.out.println(longestCollatz(1_000_000));  // 837799
//    }

}
