import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 22.09.2020
 */
public class Solution {

    private static final Map<Integer, Integer> MAP1 = new HashMap<>();
    private static final Map<Integer, Integer> MAP2 = new HashMap<>();

    static {
        int max = Integer.MIN_VALUE;
        int j = 0;

        for (int i = 2; i < 10_000; i++) {
            int val = findReciprocalCycle(i);

            if (val > max) {
                max = val;
                j = i;
            }

            MAP1.put(i, max);
            MAP2.put(max, j);
        }
    }

    private static int findReciprocalCycle(int i) {
        int[] arr = new int[i + 1];
        int j = 1;
        int mod = 1;

        while (mod != 0 && arr[mod] == 0) {
            arr[mod] = j++;
            mod = mod * 10 % i;
        }

        return mod == 0 ? 0 : j - arr[mod];
    }

    public static int findMaxReciprocalCycle(int N) {
        int maxCycle = MAP1.get(N - 1);
        return MAP2.get(maxCycle);
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(findMaxReciprocalCycle(scan.nextInt()));
    }

}
