import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.05.2018
 */
public class Solution {

private static final class MedianHeap {

    private final Queue<Integer> max;
    private final Queue<Integer> min;

    public MedianHeap(int size) {
        final Comparator<Integer> comparator = Integer::compare;
        max = new PriorityQueue<>(size, comparator.reversed());
        min = new PriorityQueue<>(size, comparator);
    }

    public void add(int val) {
        if (!min.isEmpty() && val > min.element()) {
            min.add(val);

            while (min.size() - max.size() > 0) {
                max.add(min.remove());
            }
        } else {
            max.add(val);

            while (max.size() - min.size() > 1) {
                min.add(max.remove());
            }
        }
    }

    public double median() {
        if (max.isEmpty())
            return Double.NaN;
        return max.size() == min.size() ? (max.element() + min.element()) / 2. : (double)max.element();
    }
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] a = new int[n];
        MedianHeap heap = new MedianHeap(n);

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            a[i] = aItem;
            heap.add(aItem);
            System.out.println(heap.median());
        }

        scanner.close();
    }

}
