import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 02.12.2018
 */
public class Solution {

    static int beautifulPairs(int[] A, int[] B) {
        Map<Integer, Long> map = Arrays.stream(A).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int b : B) {
            long count = map.getOrDefault(b, 0L);

            if (count == 1)
                map.remove(b);
            else
                map.put(b, count - 1);
        }

        if (map.isEmpty())
            return A.length - 1;

        int tmp = map.values().stream()
                     .filter(val -> val > 0)
                     .mapToInt(Long::intValue)
                     .sum();

        return A.length - Math.max(tmp - 1, 0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
