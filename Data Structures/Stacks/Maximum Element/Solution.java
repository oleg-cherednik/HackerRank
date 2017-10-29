import java.util.Scanner;
import java.util.Stack;

/**
 * @author Oleg Cherednik
 * @since 29.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int j = scan.nextInt();

            if (j == 1) {
                int x = scan.nextInt();
                stack.push(new Node(x, Math.max(stack.isEmpty() ? Integer.MIN_VALUE : stack.peek().max, x)));
            } else if (j == 2)
                stack.pop();
            else if (j == 3 && !stack.isEmpty())
                System.out.println(stack.peek().max);
        }
    }

    static final class Node {
        final int x;
        final int max;

        Node(int x, int max) {
            this.x = x;
            this.max = max;
        }
    }
}
