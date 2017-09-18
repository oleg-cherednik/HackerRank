package cop.hackerrank.java.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>Java Stack</h1>
 * <pre>
 * In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal
 * operations: push, which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)
 * </pre>
 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3.
 * if A is correct, (A) and {A} and [A] are also correct.<br>
 * <br>
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"<br>
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.<br>
 * <br>
 * Given a string, determine if it is balanced or not.
 * <h3>Input Format</h3>
 * There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.<br>
 * <br>
 * The part of the code that handles input operation is already provided in the editor.
 * <h3>Output Format</h3>
 * For each case, print <tt>true</tt> if the string is balanced, <tt>false</tt> otherwise.
 * <h3>Sample Input</h3>
 * <pre>
 * {}()
 * ({()})
 * {}(
 * []
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * true
 * true
 * false
 * true
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaStack {

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
