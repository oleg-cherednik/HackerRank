import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 21.07.2018
 */
public class Solution {

    static int solve(int m, List<List<Integer>> desks) {
        int res = 0;
        int max = 0;

        for (List<Integer> desk : desks) {
            res = Math.max(res, (int)Math.ceil((double)desk.get(1) / desk.get(0)));
            max += desk.get(0);
        }

        for (List<Integer> desk : desks) {
            if (m == 0)
                break;
            m = Math.max(0, m - res * desk.get(0) + desk.get(1));
        }

        if (m > 0)
            res += Math.ceil((double)m / max);

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> desks = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> desks.add(
                Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                      .map(Integer::parseInt)
                      .collect(toList())
        ));

        int result = solve(m, desks);
        System.out.println(String.valueOf(result));
    }
}
