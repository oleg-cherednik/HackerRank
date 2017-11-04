import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.11.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Queue<Integer> heap1 = new PriorityQueue<>((val1, val2) -> -Integer.compare(val1, val2));
        Queue<Integer> heap2 = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();

            if (heap1.isEmpty())
                heap1.add(a);
            else if (heap1.element() > a) {
                heap2.add(heap1.remove());
                heap1.add(a);
            } else
                heap2.add(a);

            if (heap1.size() > heap2.size() + 1)
                heap2.add(heap1.remove());
            else if (heap2.size() > heap1.size() + 1)
                heap1.add(heap2.remove());

            if (heap1.size() == heap2.size())
                System.out.format(Locale.US, "%.1f\n", (heap1.element() + heap2.element()) / 2.);
            else if (heap1.size() > heap2.size())
                System.out.format(Locale.US, "%.1f\n", (double)heap1.element());
            else
                System.out.format(Locale.US, "%.1f\n", (double)heap2.element());
        }

        scan.close();
    }
}

