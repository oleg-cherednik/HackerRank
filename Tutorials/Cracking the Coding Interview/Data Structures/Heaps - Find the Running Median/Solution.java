import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {
    static final class Node {
        private final int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class Heap {

        private final int[] a;
        private int total;

        public Heap(int[] a) {
            this.a = a;
        }

        public void add(int val) {
            total++;
        }

        public double median() {
            if (total == 0)
                return -1;
            int m = total / 2;
            return total % 2 == 0 ? (a[m] + a[m + 1]) / 2. : a[m];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];
        Heap heap = new Heap(a);

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            System.out.println(heap.median());
        }

        scanner.close();
    }

}
