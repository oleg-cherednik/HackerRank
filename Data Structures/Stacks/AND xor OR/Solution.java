import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 31.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scan.nextInt();

        Deque<Integer> stack = new LinkedList<>();

        int max = 0;
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            int a = arr[stack.element()];
            int b = arr[i];

            if (a == b)
                continue;

            if (a < b) {
                max = Math.max(max, sum(a, b));
            } else {
                while (!stack.isEmpty() && arr[stack.element()] > b) {
                    max = Math.max(max, sum(arr[stack.pop()], b));
                }

                if (!stack.isEmpty())
                    max = Math.max(max, sum(arr[stack.element()], b));
            }

            stack.push(i);
        }

        System.out.println(max);
    }

    private static int sum(int a, int b) {
        return ((a & b) ^ (a | b)) & (a ^ b);
    }
}
