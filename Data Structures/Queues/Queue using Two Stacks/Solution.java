import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.11.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        scan.nextLine();

        Queue queue = new Queue();

        for (int i = 0; i < q; i++) {
            int t = scan.nextInt();

            if (t == 1)
                queue.enqueue(scan.nextInt());
            else if (t == 2)
                queue.dequeue();
            else if (t == 3)
                System.out.println(queue.element());
        }

        scan.close();
    }

    private static class Queue {
        private final Deque<Integer> stack1 = new LinkedList<>();
        private final Deque<Integer> stack2 = new LinkedList<>();

        public void enqueue(int val) {
            stack1.push(val);
        }

        public int dequeue() {
            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());

            return stack2.pop();
        }

        public int element() {
            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());

            return stack2.element();
        }
    }

}
