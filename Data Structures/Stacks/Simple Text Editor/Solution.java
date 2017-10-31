import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.11.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        scan.nextLine();

        StringBuilder buf = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < Q; i++) {
            int t = scan.nextInt();

            if (t == 1) {
                buf.append(scan.next());
                stack.push(buf.toString());
            } else if (t == 2) {
                buf.setLength(buf.length() - scan.nextInt());
                stack.push(buf.toString());
            } else if (t == 3)
                System.out.println(buf.toString().charAt(scan.nextInt() - 1));
            else if (t == 4) {
                stack.pop();
                buf.setLength(0);
                buf.append(stack.isEmpty() ? "" : stack.element());
            }
        }

        scan.close();
    }
}
