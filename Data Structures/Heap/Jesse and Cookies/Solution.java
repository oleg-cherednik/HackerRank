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
        int N = scan.nextInt();
        int K = scan.nextInt();
        scan.nextLine();

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            queue.add(scan.nextInt());

        scan.close();
        int res = 0;

        while (queue.size() > 1 && queue.peek() < K) {
            int a = queue.poll();
            int b = queue.poll();

            queue.add(a + 2 * b);
            res++;
        }

        System.out.print(queue.peek() < K ? -1 : res);
    }
}

