import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.11.2017
 */
public class Solution {
    public static void main(String[] args) {
        class Customer {
            private final int t;
            private final int l;

            public Customer(int t, int l) {
                this.t = t;
                this.l = l;
            }
        }

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        Queue<Customer> heap = new PriorityQueue<>(Comparator.comparingInt(c -> c.t));

        for (int i = 0; i < N; i++) {
            int t = scan.nextInt();
            int l = scan.nextInt();
            heap.add(new Customer(t, l));
        }

        scan.close();

        while(true) {
            Customer customer = heap.remove();
            Queue<Customer> tmp = new PriorityQueue<>(Comparator.comparingInt(c -> c.t));

            while(heap.element().t <= (customer.t + customer.l)) {
                tmp.add(heap.remove());
            }


            int a = 0;
            a++;

        }

    }


}

