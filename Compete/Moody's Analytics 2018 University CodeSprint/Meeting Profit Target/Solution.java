import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {
    static int solve(List<List<Integer>> profits) {
        long sum = 0;

        for (List<Integer> profit : profits) {
            int actual = profit.get(0);
            int estimated = profit.get(1);
            int delta = actual - estimated;

            sum = Math.min(0, sum + delta);
        }

        return sum < 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = Integer.parseInt(scan.nextLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                int n = Integer.parseInt(scan.nextLine().trim());

                List<List<Integer>> profits = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    profits.add(
                            Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                                  .map(Integer::parseInt)
                                  .collect(toList())
                    );
                });

                int res = solve(profits);

                System.out.println(String.valueOf(res));
            });
        }
    }

}
