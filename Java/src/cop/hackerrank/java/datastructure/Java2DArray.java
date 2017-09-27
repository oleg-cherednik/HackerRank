package cop.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * <h1>Java 2D Array</h1>
 * You are given a <b>6x6</b>  2D array. An hourglass in an array is a portion shaped like this:
 * <pre>
 * a b c
 *   d
 * e f g
 * </pre>
 * For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
 * <pre>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * </pre>
 * Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
 * <pre>
 * 1 1 1     1 1 0     1 0 0
 *   1         0         0
 * 1 1 1     1 1 0     1 0 0
 * </pre>
 * The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.<br>
 * In this problem you have to <i>print the largest sum among all the hourglasses</i> in the array.
 * <h3>Input Format</h3>
 * There will be exactly 6lines, each containing 6 integers separated by spaces. Each integer will be between -9 and 9 and inclusive.
 * <h3>Output Format</h3>
 * Print the answer to this problem on a single line.
 * <h3>Sample Input</h3>
 * <pre>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * </pre>
 * <h3>Sample Output</h3>
 * 19
 * <h3>Explanation</h3>
 * The hourglass which has the largest sum is:
 * <pre>
 * 2 4 4
 *   2
 * 1 2 4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Java2DArray {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                arr[i][j] = in.nextInt();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr[j][i] + arr[j][i + 1] + arr[j][i + 2];
                sum += arr[j + 1][i + 1];
                sum += arr[j + 2][i] + arr[j + 2][i + 1] + arr[j + 2][i + 2];
                res = Math.max(res, sum);
            }
        }

        System.out.println(res);
    }
}
