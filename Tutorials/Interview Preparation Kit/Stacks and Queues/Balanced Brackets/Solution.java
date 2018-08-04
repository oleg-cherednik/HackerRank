import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    private static String isBalanced(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return "NO";
                char prv = stack.pop();

                if (ch == ')' && prv != '(' || ch == '}' && prv != '{' || ch == ']' && prv != '[')
                    return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }

        scanner.close();
    }

}
