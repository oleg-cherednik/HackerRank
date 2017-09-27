package cop.hackerrank.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Java List</h1>
 * For this problem, we have 2 types of queries you can perform on a List:
 * <ol>
 * <li>
 * Insert <tt>y</tt> at index <tt>x</tt>:
 * <pre>
 * Insert
 * x y
 * </pre>
 * </li>
 * <li>
 * Delete the element at index <tt>x</tt>:
 * <pre>
 * Delete
 * x
 * </pre>
 * </li>
 * </ol>
 * Given a list, <tt>L</tt>, of <tt>N</tt> integers, perform <tt>Q</tt> queries on the list. Once all queries are completed, print the modified list
 * as a single line of space-separated integers.
 * <h3>Input Format</h3>
 * The first line contains an integer, <tt>N</tt> (the initial number of elements in <tt>L</tt>).<br>
 * The second line contains <tt>N</tt> space-separated integers describing <tt>L</tt>.<br>
 * The third line contains an integer, <tt>Q</tt> (the number of queries).<br>
 * The <tt>2Q</tt> subsequent lines describe the queries, and each query is described over two lines:
 * <ul>
 * <li>If the first line of a query contains the String <b>Insert</b>, then the second line contains two space separated integers <tt>x y</tt>, and
 * the value <tt>y</tt> must be inserted into <tt>L</tt> at index <tt>x</tt>.</li>
 * <li>If the first line of a query contains the String <b>Delete</b>, then the second line contains index <tt>x</tt>, whose element must be deleted
 * from <tt>L</tt>.</li>
 * </ul>
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= N <= 4000</li>
 * <li>1 <= Q <= 4000</li>
 * <li>Each element in is a <i>32-bit integer</i>.</li>
 * </ul>
 * <h3>Output Format</h3>
 * Print the updated list <tt>L</tt> as a single line of space-separated integers.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * 12 0 1 78 12
 * 2
 * Insert
 * 5 23
 * Delete
 * 0
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 0 1 78 12 23
 * </pre>
 * <h3>Explanation</h3>
 * L = [12,0,1,78,12]<br>
 * <br>
 * Q<sub>0</sub>: <b>Insert</b> 23 at index 5.<br>
 * L<sub>0</sub> = [12,0,1,78,12,23]<br>
 * <br>
 * Q<sub>1</sub>: <b>Delete</b> the element at index 0.<br>
 * L<sub>1</sub> = [0,1,78,12,23]
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaList {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        int n = scan.nextInt();

        for (int i = 0; i < n; i++)
            data.add(scan.nextInt());

        int q = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < q; i++) {
            String cmd = scan.next();

            if ("Insert".equalsIgnoreCase(cmd))
                data.add(scan.nextInt(), scan.nextInt());
            else if ("Delete".equalsIgnoreCase(cmd))
                data.remove(scan.nextInt());

            scan.nextLine();
        }

        boolean space = false;

        for (int val : data) {
            if (space)
                System.out.print(" ");
            System.out.print(val);
            space = true;
        }
    }
}
