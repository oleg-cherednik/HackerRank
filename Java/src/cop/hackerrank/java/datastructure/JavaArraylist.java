package cop.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * <h1>Java Arraylist</h1>
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.<br>
 * You are given n lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in
 * y<sup>th</sup> position of x<sup>th</sup> line.<br>
 * Take your input from System.in.
 * <h3>Input Format</h3>
 * The first line has an integer <tt>n</tt>. In each of the next n lines there will be an integer <tt>d</tt> denoting number of integers on that line
 * and then there will be <tt>d</tt> space-separated integers. In the next line there will be an integer <tt>q</tt> denoting number of queries. Each
 * query will consist of two integers <tt>x</tt> and <tt>y</tt>.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= n <= 20000</li>
 * <li>0 <= d <= 50000</li>
 * <li>1 <= q <= 1000</li>
 * <li>1 <= x <= n</li>
 * </ul>
 * Each number will fit in signed integer.<br>
 * Total number of integers in n ines will not cross 10<sup>5</sup>.
 * <h3>Output Format</h3>
 * In each line, output the number located in y<sup>th</sup> position of x<sup>th</sup> line. If there is no such position, just print
 * <tt>"ERROR!"</tt>.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 * </pre>
 * <h3>Explanation</h3>
 * The diagram below explains the queries:
 * <pre>
 * <img src="image.png"/>
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 16.09.2017
 */
public class JavaArraylist {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            arr[i] = new int[d];

            for (int j = 0; j < d; j++)
                arr[i][j] = scan.nextInt();
        }

        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;

            if (arr.length <= x || arr[x] == null || arr[x].length <= y)
                System.out.println("ERROR!");
            else
                System.out.println(arr[x][y]);
        }
    }
}
