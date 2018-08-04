import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    static long countTriplets(List<Long> arr, long r) {
        class Node {

            long count;
            long pairs;
        }

        long res = 0;
        Map<Long, Node> map = new HashMap<>();

        for (long val : arr) {
            Node node = map.computeIfAbsent(val, v -> new Node());
            Node prv = map.get(val / r);

            if (prv != null && val % r == 0) {
                res += prv.pairs;
                node.pairs += prv.count;
            }

            node.count++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nr = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                               .map(Long::parseLong)
                               .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));

        scanner.close();
    }

}
