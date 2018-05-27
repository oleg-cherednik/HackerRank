import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.05.2018
 */
public class Solution {

    private static boolean isBalanced(String str) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                char prv = stack.pop();

                if (ch == ')' && prv != '(' || ch == '}' && prv != '{' || ch == ']' && prv != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            System.out.println(isBalanced(expression) ? "YES" : "NO");
        }

        scanner.close();
    }

}
