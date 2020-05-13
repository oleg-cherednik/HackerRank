import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.05.2020
 */
public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double median = 0;

        for (int i = -d, j = 0; j < expenditure.length; i++, j++) {
            int val = expenditure[j];

            if (i >= 0) {
                if (val >= median * 2)
                    res++;

                if (!maxHeap.remove(expenditure[i]))
                    minHeap.remove(expenditure[i]);
            }

            if (minHeap.size() == maxHeap.size()) {
                if (val < median)
                    maxHeap.add(val);
                else
                    minHeap.add(val);
            } else {
                if (minHeap.size() > maxHeap.size()) {
                    if (val < median)
                        maxHeap.add(val);
                    else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(val);
                    }
                } else {
                    if (val < median) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(val);
                    } else
                        minHeap.add(val);
                }
            }

            if (minHeap.size() > maxHeap.size())
                median = minHeap.element();
            else if (minHeap.size() < maxHeap.size())
                median = maxHeap.element();
            else
                median = (minHeap.element() + maxHeap.element()) / 2.0;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
