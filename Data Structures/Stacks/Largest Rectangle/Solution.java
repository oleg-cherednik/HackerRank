import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 31.10.2017
 */
public class Solution {
    static long largestRectangle(int[] h) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int val : h) {
            if (stack.isEmpty() || stack.element() <= val)
                stack.push(val);
            else {
                int i = 1;

                while (!stack.isEmpty() && stack.element() > val) {
                    max = Math.max(max, stack.pop() * i++);
                }

                for (int j = 0; j < i; j++)
                    stack.push(val);
            }
        }

        if (!stack.isEmpty()) {
            int i = 1;

            while (!stack.isEmpty()) {
                max = Math.max(max, stack.pop() * i++);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int h_i = 0; h_i < n; h_i++) {
            h[h_i] = in.nextInt();
        }
        long result = largestRectangle(h);
        System.out.println(result);
        in.close();
    }
}
