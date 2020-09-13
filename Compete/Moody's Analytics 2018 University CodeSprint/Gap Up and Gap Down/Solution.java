import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 18.08.2018
 */
public class Solution {

    static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {
        Iterator<Integer> itLow = low.iterator();
        Iterator<Integer> itHigh = high.iterator();
        Iterator<Integer> itClose = close.iterator();

        int gapUp = 0;
        int gapDown = 0;
        int prvClose = Integer.MIN_VALUE;

        while (itLow.hasNext() && itHigh.hasNext() && itClose.hasNext()) {
            int curLow = itLow.next();
            int curHigh = itHigh.next();
            int curClose = itClose.next();

            if (prvClose != Integer.MIN_VALUE) {
                gapUp += curLow > prvClose ? 1 : 0;
                gapDown += curHigh < prvClose ? 1 : 0;
            }

            prvClose = curClose;
        }

        System.out.println(gapUp + " " + gapDown);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());

        List<Integer> low = Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                                  .map(Integer::parseInt)
                                  .collect(toList());

        List<Integer> high = Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                                   .map(Integer::parseInt)
                                   .collect(toList());

        List<Integer> close = Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList());

        solve(low, high, close);
    }

}
