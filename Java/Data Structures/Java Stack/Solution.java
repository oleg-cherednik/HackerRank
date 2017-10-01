import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Deque<Character> stack = new LinkedList<>();
            boolean res = true;

            for (char ch : input.toCharArray()) {
                if (ch == '{' || ch == '(' || ch == '[')
                    stack.push(ch);
                else if (ch == '}' || ch == ')' || ch == ']') {
                    char prv = stack.isEmpty() ? '\0' : stack.pop();

                    if (ch == '}' && prv != '{' || ch == ')' && prv != '(' || ch == ']' && prv != '[') {
                        res = false;
                        break;
                    }
                }
            }

            System.out.println(res && stack.isEmpty());
        }
    }
}
