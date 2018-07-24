import java.util.Collections;
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

    static int solve(List<Integer> customer, int k) {
        Collections.sort(customer);

        int res = 0;
        int i = -1;

        for (int cust : customer) {
            if (i == -1 || cust > i) {
                res++;
                i = cust + 2 * k;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            int customerCount = Integer.parseInt(scanner.nextLine().trim());

            List<Integer> customer = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                                           .map(Integer::parseInt)
                                           .collect(toList());

            int k = Integer.parseInt(scanner.nextLine().trim());

            int result = solve(customer, k);
            System.out.println(String.valueOf(result));
        });
    }
}
