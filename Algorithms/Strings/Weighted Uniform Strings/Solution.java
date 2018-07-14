import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] groups = s.split("(?<=(.))(?!\\1)");
        Map<Character, String> map = new HashMap<>();

        Arrays.stream(groups).forEach(
                group -> map.compute(group.charAt(0), (ch, existed) -> existed == null || group.length() > existed.length() ? group : existed));

        Set<Integer> weights = new HashSet<>();

        map.forEach((ch, group) -> {
            int weight = ch - 'a' + 1;
            int sum = 0;

            for (int i = 0; i < group.length(); i++)
                weights.add(sum += weight);
        });

        String[] res = new String[queries.length];

        for (int i = 0; i < res.length; i++)
            res[i] = weights.contains(queries[i]) ? "Yes" : "No";

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
