import java.util.Scanner;
import java.util.Stack;

/**
 * @author Oleg Cherednik
 * @since 29.10.2017
 */
public class Solution {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{'))
                return "NO";
            else if (ch == ']' && (stack.isEmpty() || stack.pop() != '['))
                return "NO";
            else if (ch == ')' && (stack.isEmpty() || stack.pop() != '('))
                return "NO";
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
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
