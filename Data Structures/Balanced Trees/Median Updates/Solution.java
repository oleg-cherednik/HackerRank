import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.02.2018
 */
public class Solution {

    private static void calc(int N, Scanner scan) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scan.next();
            int num = scan.nextInt();

            if ("a".equals(command)) {
                if (maxHeap.isEmpty())
                    maxHeap.add(num);
                else if (maxHeap.element() > num) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                } else
                    minHeap.add(num);

                balance(minHeap, maxHeap);
                buf.append(median(minHeap, maxHeap));
            } else if ("r".equals(command)) {
                boolean found = minHeap.remove(num);

                if (!found)
                    found = maxHeap.remove(num);

                if (found) {
                    balance(minHeap, maxHeap);
                    buf.append(median(minHeap, maxHeap));
                } else
                    buf.append("Wrong!");
            }

            buf.append('\n');
        }

        System.out.println(buf);
    }

    private static void balance(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.remove());
        else if (minHeap.size() > maxHeap.size() + 1)
            maxHeap.add(minHeap.remove());
    }

    private static String median(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if (minHeap.isEmpty() && maxHeap.isEmpty())
            return "Wrong!";
        double median;

        if (maxHeap.size() == minHeap.size())
            median = ((long)maxHeap.element() + minHeap.element()) / 2.;
        else if (maxHeap.size() > minHeap.size())
            median = (double)maxHeap.element();
        else
            median = (double)minHeap.element();

        if ((median == Math.floor(median)) && !Double.isInfinite(median))
            return String.valueOf((int)median);
        return String.format(Locale.US, "%.1f", median);
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            calc(N, scan);
        }
    }
}
